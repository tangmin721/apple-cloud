package com.cachexic.cloud.generator.code;

import com.cachexic.cloud.common.base.annotations.Entity;
import com.cachexic.cloud.common.exceptions.BizException;
import com.cachexic.cloud.common.exceptions.BizExceptionEnum;
import com.cachexic.cloud.generator.bean.EntityInfo;
import com.cachexic.cloud.generator.bean.GenConfig;
import com.cachexic.cloud.generator.bean.IdTypeEnum;
import com.cachexic.cloud.generator.tmplate.ConsumerControllerGenerator;
import com.cachexic.cloud.generator.tmplate.ControllerGenerator;
import com.cachexic.cloud.generator.tmplate.DaoGenerator;
import com.cachexic.cloud.generator.tmplate.FeignClientFallbackFactoryGenerator;
import com.cachexic.cloud.generator.tmplate.FeignClientGenerator;
import com.cachexic.cloud.generator.tmplate.FeignClientWithFallBackFactoryGenerator;
import com.cachexic.cloud.generator.tmplate.MybatisXmlGenerator;
import com.cachexic.cloud.generator.tmplate.MybatisXmlJoinGenerator;
import com.cachexic.cloud.generator.tmplate.MysqlDDLGenerator;
import com.cachexic.cloud.generator.tmplate.QueryGenerator;
import com.cachexic.cloud.generator.tmplate.ServiceGenerator;
import com.cachexic.cloud.generator.tmplate.ServiceImplGenerator;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import org.apache.commons.lang3.StringUtils;

/**
 * @author tangmin
 * @version V1.0
 * @Title: CodeGenerator.java
 * @Package com.gasq.cloud.generator.generator
 * @Description: 代码生成器
 * @date 2017-04-26 16:26:23
 */
public class CodeGenerator {

    /** 需要生成的类 */
    private Class<?> clazz;

    /** 是否继承BaseEntity */
    private String extendBaseEntity;

    /** 是否启用乐观锁 */
    private String openVersion;

    /** 主键类型 */
    private int idType = IdTypeEnum.AUTO_INCR.getCode();

    /** 微服务名称 */
    private String serverName;

    /** 实体对应的表名 */
    private String tableName;

    /** requestMapping路径 */
    private String requestMapPath;

    /** 模块名 */
    private String modelName;

    public String getExtendBaseEntity() {
        return extendBaseEntity;
    }

    public void setExtendBaseEntity(String extendBaseEntity) {
        this.extendBaseEntity = extendBaseEntity;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }


    public String getRequestMapPath() {
        return requestMapPath;
    }

    public void setRequestMapPath(String requestMapPath) {
        this.requestMapPath = requestMapPath;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getOpenVersion() {
        return openVersion;
    }

    public void setOpenVersion(String openVersion) {
        this.openVersion = openVersion;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
        if(clazz.getAnnotation(Entity.class)==null || StringUtils.isBlank(clazz.getAnnotation(Entity.class).value())){
            throw new BizException(BizExceptionEnum.SYS_EXCEPTION.getCode(),"@Entity(\"t_table_name\") is must not null");
        }
        this.tableName = (clazz.getAnnotation(Entity.class).value());
        this.requestMapPath = (StringUtils.uncapitalize(clazz.getSimpleName()));
    }

    public void writeFile(File dir, String fileName, String content)
            throws Exception {
        File file = new File(dir, fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        Writer writer = null;
        try {
            writer = new FileWriter(file);
            writer.write(content);
            writer.flush();
        } finally {
            writer.close();
        }
    }

    /**
     * 配置生成文件存放位置，生成的表名
     *
     * @param path
     * @throws Exception
     */
    public void outPut(String path) throws Exception {
        System.out.println("代码生成器开始运行...");
        long startTime = System.nanoTime();
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        GenConfig genConfig = new GenConfig();


        //加载配置
        genConfig.setServerName(serverName);
        genConfig.setOpenVersion(openVersion);
        genConfig.setRequestMapPath(requestMapPath);
        genConfig.setModelName(modelName);
        genConfig.setIdType(idType);
        genConfig.setExtendBaseEntity(extendBaseEntity);

        //根据模板生成代码
        MysqlDDLGenerator mysql = new MysqlDDLGenerator();
        MybatisXmlGenerator xmlGenerator = new MybatisXmlGenerator();
        MybatisXmlJoinGenerator xmlJoinGenerator = new MybatisXmlJoinGenerator();
        QueryGenerator query = new QueryGenerator();
        DaoGenerator dao = new DaoGenerator();
        ServiceGenerator service = new ServiceGenerator();
        ServiceImplGenerator serviceImpl = new ServiceImplGenerator();
        ControllerGenerator controller = new ControllerGenerator();
        ConsumerControllerGenerator consumerController = new ConsumerControllerGenerator();
        FeignClientWithFallBackFactoryGenerator withFallbackFactory = new FeignClientWithFallBackFactoryGenerator();
        FeignClientFallbackFactoryGenerator fallbackFactory = new FeignClientFallbackFactoryGenerator();
        FeignClientGenerator feignClien = new FeignClientGenerator();

        EntityInfo entity = new EntityInfo(clazz, tableName);
        writeFile(dir, tableName + ".sql",
                mysql.generateCode(entity, genConfig));
        writeFile(dir, entity.getClassName() + "Query.java",
                query.generateCode(entity, genConfig));
        writeFile(dir, entity.getClassName() + "Dao.xml",
                xmlGenerator.generateCode(entity, genConfig));
        writeFile(dir, "JOIN_" + entity.getClassName() + "Dao.xml",
                xmlJoinGenerator.generateCode(entity, genConfig));
        writeFile(dir, entity.getClassName() + "Dao.java",
                dao.generateCode(entity, genConfig));
        writeFile(dir, entity.getClassName() + "Service.java",
                service.generateCode(entity, genConfig));
        writeFile(dir, entity.getClassName() + "ServiceImpl.java",
                serviceImpl.generateCode(entity, genConfig));
        writeFile(dir, entity.getClassName() + "Controller.java",
                controller.generateCode(entity, genConfig));
        writeFile(dir, entity.getClassName() + "WebController.java",
                consumerController.generateCode(entity, genConfig));
//        writeFile(dir, entity.getClassName() + "FeignClientWithFallbackFactory.java",
//                withFallbackFactory.generateCode(entity, genConfig));
        writeFile(dir, entity.getClassName() + "FeignFallback.java",
                fallbackFactory.generateCode(entity, genConfig));
        writeFile(dir, entity.getClassName() + "Feign.java",
                feignClien.generateCode(entity, genConfig));

        Runtime.getRuntime().exec("cmd /c start " + path);
        System.out.println("生成代码成功!!!耗时:"+(System.nanoTime()-startTime)/(1000*1000) +"ms.");
    }


}
