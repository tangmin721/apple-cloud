package com.cachexic.cloud.config;

import static com.alibaba.druid.filter.config.ConfigTools.encrypt;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * Created by tangm on 2017/8/28.
 */
public class DBConfigTools {

    public static void main(String[] args) throws Exception {
        String ptestwd = "root1234";
        String[] arr = ConfigTools.genKeyPair(512);
        System.out.println("privateKey:" + arr[0]);
        System.out.println("publicKey:" + arr[1]);
        System.out.println("password:" + encrypt(arr[0], ptestwd));

    }
}
