package com.cachexic.cloud.provider.msg.example.completable;

import com.cachexic.cloud.common.utils.json.JsonUtil;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.util.Lists;

public class BestPriceFinder {

    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
        new Shop("LetsSaveBig"),
        new Shop("MyFavoriteShop"),
        new Shop("BuyItAll"),
        new Shop("BuyItAll1"),
        new Shop("BuyItAll2"),
        new Shop("BuyItAll3"),
        new Shop("BuyItAll3"),
        new Shop("ShopEasy"));

    private final Executor executor = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    /**
     * 以最简单的方式实现使用Discount服务的findPrices方法
     *
     * @param product
     * @return
     */
    public List<String> findPricesSequential(String product) {
        return shops.stream()
            .map(shop -> shop.getPrice(product)) //取得每个shop对象中商品的原始价格 每个耗时1s
            .map(Quote::parse)//转换，耗时忽略
            .map(Discount::applyDiscount)   //联系discount服务为每个quote申请折扣，每个耗时1s
            .collect(Collectors.toList());//结果100034ms
    }

    /**
     * 以parallelStream运行
     *
     * @param product
     * @return
     */
    public List<String> findPricesParallel(String product) {
        return shops.parallelStream()
            .map(shop -> shop.getPrice(product)) //耗时1s   如果eshop数量大于本机器的cup核数8，比如9时，则还会增加耗时1s
            .map(Quote::parse)
            .map(Discount::applyDiscount)//耗时1s   9   +1s
            .collect(Collectors.toList());//总耗时2s  9=4s
    }

    /**
     * 自定义线程数量的运行方式
     *
     * @param product
     * @return
     */
    public List<String> findPricesFuture(String product) {
        List<CompletableFuture<String>> priceFutures = findPricesStream(product)
            .collect(Collectors.toList());

        return priceFutures.stream()
            .map(CompletableFuture::join)//等待流中的所有 Future 执行 完毕，并提取各自的返回值
            .collect(Collectors.toList());
    }

    /**
     * 使用 CompletableFuture 实现 findPrices 方法
     *
     * 2、thenApply：你可以对第一步中生成的 CompletableFuture 对象调用它的thenApply ，将一个由字符串转换 Quote 的方法作为参数传递给它。
     * 3、thenCompose： 方法允许你对两个异步操作进行流水线，第一个操作完成时，将其 结果作为参数传递给第二个操作
     * 4、thenCombine：你需要将两个完全不相干的 CompletableFuture 对象的结果整合起来，而且你也不希望等到第一个任务完全结束才开始第二项任务。
     * @param product
     * @return
     */
    public Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream()
            .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor)) //1、以异步方式取得每个shop中指定产品的原始价格
            .map(future -> future.thenApply(Quote::parse))//2、Quote 对象存在时，对 其返回的值进行转换。将 Stream 中的每个 CompletableFuture<String> 对象转换为对应的CompletableFuture<Quote> 对象
            .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)));//3、使用另一个异步任务构造期望的 Future申请折扣
    }

    /**
     * thenAccept：定义了如何处理 CompletableFuture 返回的结果，一旦CompletableFuture 计算得到结果，它就返回一个 CompletableFuture<Void> 。
     * 故意抛异常，能获取到多少算多少的result
     * @param product
     */
    public void printPricesStream(String product) {
        List<String> result = Lists.newArrayList();
        try {
            long start = System.nanoTime();
            CompletableFuture[] futures = findPricesStream(product)
                .map(f -> f.thenAccept((String s) -> {
                    System.out.println(s + " (done in " + ((System.nanoTime() - start) / 1_000_000) + " msecs)");
                    String s1 = null;
                    try {
                        s1 = f.get(1200L, TimeUnit.MICROSECONDS);
                        System.out.println(s1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (TimeoutException e) {
                        e.printStackTrace();
                    }
                    result.add(s1);
                }))
                .toArray(size -> new CompletableFuture[size]);
            Void join = CompletableFuture.allOf(futures).join();
            System.out.println("All shops have now responded in " + ((System.nanoTime() - start) / 1_000_000) + " msecs");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("result string:"+JsonUtil.toJson(result)+",size:"+result.size());

    }

}
