package com.cachexic.cloud.generator.bean;

/**
 * 配置
 *
 * @author tangmin
 * @date 2016年2月26日
 */
public class GenConfig {

    private String dbType = "mysql";

    /**
     * id类型
     */
    private int idType;

    /**
     * 是否继承BaseEntity
     */
    private String extendBaseEntity;
    /**
     * 微服务名称
     */
    private String serverName;

    /**
     * requestMapping路径
     */
    private String requestMapPath;

    /**
     * tableName
     */
    private String tableName;

    /**
     * 模块名称
     */
    private String modelName;

    public String getExtendBaseEntity() {
        return extendBaseEntity;
    }

    public void setExtendBaseEntity(String extendBaseEntity) {
        this.extendBaseEntity = extendBaseEntity;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
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

}
