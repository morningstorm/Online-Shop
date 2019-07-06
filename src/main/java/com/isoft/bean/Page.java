package com.isoft.bean;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
    /**
     * 第几页
     */
    private Integer page ;
    /**
     * 每页记录个数
     */
    private Integer size ;
    /**
     * 总记录个数
     */
    private Integer rowCount ;
    /**
     * 总页码
     */
    private Integer pageCount ;
    /**
     * 本页数据
     */
    List<T> pageData ;

    public Page() {
    }

    public Page(Integer page, Integer size, Integer rowCount, List<T> pageData) {
        this.page = page;
        this.size = size;
        this.rowCount = rowCount;
        this.pageCount = (int)(Math.ceil(rowCount * 1.0 / size));
        this.pageData = pageData;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
        this.pageCount = (int)(Math.ceil(rowCount * 1.0 / size));
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", size=" + size +
                ", rowCount=" + rowCount +
                ", pageCount=" + pageCount +
                ", pageData=" + pageData +
                '}';
    }
}
