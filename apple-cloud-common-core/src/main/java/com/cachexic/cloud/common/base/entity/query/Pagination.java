package com.cachexic.cloud.common.base.entity.query;

import com.cachexic.cloud.common.constants.SystemConst;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

/**
 * @author tangmin
 * @Description: 分页对象包装类
 * @date 2017-09-16 19:21:30
 */
public class Pagination<T> implements Serializable {
    private static final long serialVersionUID = 5399980318862132190L;

    private long DEFAULT_PAGE_SIZE = SystemConst.DEFAULT_PAGE_SIZE;

    @ApiModelProperty("返回的list集合")
    private List<T> list = Lists.newArrayList();

    @ApiModelProperty(value = "当前页", example = "10", position = 1)
    private Long currentPage;

    @ApiModelProperty(value = "每页记录条数", example = "10", position = 2)
    private Long pageSize = DEFAULT_PAGE_SIZE;

    @ApiModelProperty(value = "总记录条数", example = "50", position = 3)
    private Long total;

    @ApiModelProperty(value = "总页数", example = "5", position = 4)
    private Long pageCount = 0l;

    /** 起始行,用于页面序号相加 */
    @JsonIgnore
    private Long pageStart = 0l;

    /** 是否使用小型分页样式 */
    @JsonIgnore
    protected boolean small;

    /**
     * 私有化无参构造，feign层调用的时候用到对象的转换
     */
    private Pagination() {
    }

    public Pagination(Long currentPage, Long pageSize, Long total) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.total = total;

        if (total > 0) {
            this.pageCount = (total + pageSize - 1) / pageSize;
            this.pageStart = pageSize * (currentPage - 1);
        }
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Long getPageStart() {
        return pageStart;
    }

    public void setPageStart(Long pageStart) {
        this.pageStart = pageStart;
    }

    public boolean isSmall() {
        return small;
    }

    public void setSmall(boolean small) {
        this.small = small;
    }
}
