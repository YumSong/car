package com.zhbit.car.service.core.page;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页封装request
 * @param <T>
 */
public class PageRequest<T> implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6443776113241100665L;

	public static final int DEFAULT_PAGE_SIZE = 10;

    private T filters;
    private int pageNumber;
    private int pageSize = 10;
    private String sortColumns;

    public PageRequest() {
    }

    public PageRequest(T filters) {
        setFilters(filters);
    }

    public PageRequest(int pageNumber, int pageSize) {
        this(pageNumber, pageSize, (T) null);
    }

    public PageRequest(int pageNumber, int pageSize, T filters) {
        this(pageNumber, pageSize, filters, null);
    }

    public PageRequest(int pageNumber, int pageSize, String sortColumns) {
        this(pageNumber, pageSize, null, sortColumns);
    }

    public PageRequest(int pageNumber, int pageSize, T filters, String sortColumns) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        setFilters(filters);
        setSortColumns(sortColumns);
    }

    public T getFilters() {
        return this.filters;
    }

    public void setFilters(T filters) {
        this.filters = filters;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortColumns() {
        return this.sortColumns;
    }

    public void setSortColumns(String sortColumns) {
        checkSortColumnsSqlInjection(sortColumns);
        if ((sortColumns != null) && (sortColumns.length() > 200)) {
            throw new IllegalArgumentException("sortColumns.length() <= 200 must be true");
        }
        this.sortColumns = sortColumns;
    }

    public List<SortInfo> getSortInfos() {
        return Collections.unmodifiableList(SortInfo.parseSortColumns(this.sortColumns));
    }

    private void checkSortColumnsSqlInjection(String sortColumns) {
        if (sortColumns == null){
            return;
        }
        if ((sortColumns.indexOf("'") >= 0) || (sortColumns.indexOf("\\") >= 0)){
            throw new IllegalArgumentException("sortColumns:" + sortColumns + " has SQL Injection risk");
        }
    }
}