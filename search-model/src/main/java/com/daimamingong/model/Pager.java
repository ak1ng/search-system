package com.daimamingong.model;

import java.util.List;

/**
 * 分页对象，如果需要分页则需要继承该类，而不是继承BaseDto
 *
 * @author robben.qu
 */
public class Pager<T> extends Base<T> {

    private static final long serialVersionUID = -3636360850568459624L;

    private static final int DEFAULT_PAGE_NUM = 1;

    private static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 当前页
     */
    private Integer pageNum = DEFAULT_PAGE_NUM;

    /**
     * 每页显示条数
     */
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    /*
     * 总页数
     */
    private Integer pages;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 数据记录
     */
    private List<?> data;

    /**
     * 分页偏移
     */
    private int startIndex;

    /**
     * 排序字段
     */
    private String sidx;

    /**
     * 排序方式
     */
    private String sord;

    /**
     * 搜索字段
     */
    private String searchField;

    /**
     * 搜索操作（等于，大于，开始于，不等于等等）
     */
    private String searchOper;

    /**
     * 搜索的值
     */
    private String searchString;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum > 0)
            this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize > 0)
            this.pageSize = pageSize;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public int getStartIndex() {
        return (pageNum - 1) * pageSize;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public String getSearchOper() {
        return searchOper;
    }

    public void setSearchOper(String searchOper) {
        this.searchOper = searchOper;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
