package com.zhbit.car.service.core.page;

import java.io.Serializable;

/**
 * 分页查询
 * 
 */
public class PageQuery implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 4997561056826938666L;
	public static final int DEFAULT_PAGE_SIZE = 10;
    private int page;
    private int pageSize = 10;

    public PageQuery() {
    }

    public PageQuery(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageQuery(PageQuery query) {
        this.page = query.page;
        this.pageSize = query.pageSize;
    }

    public PageQuery(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String toString() {
        return "page:" + this.page + ",pageSize:" + this.pageSize;
    }
}