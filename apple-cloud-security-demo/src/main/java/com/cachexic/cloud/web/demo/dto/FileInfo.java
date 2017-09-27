package com.cachexic.cloud.web.demo.dto;

/**
 * @author tangmin
 * @Description: 文件上传测试
 * @date 2017-09-27 09:27:59
 */
public class FileInfo {
    private String path;

    public FileInfo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
