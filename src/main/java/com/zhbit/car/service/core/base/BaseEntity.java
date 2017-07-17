package com.zhbit.car.service.core.base;

import java.io.Serializable;

/**
 * BaseEntity 基础实体类
 */
public class BaseEntity implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = -8143994552798778393L;

    protected static final String DATE_FORMAT = "yyyy-MM-dd";

    protected static final String TIME_FORMAT = "HH:mm:ss";

    protected static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    protected static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";

    // 排序
    private String orderStr;

    //排序规则
    private String sort;

    //排序字段
    private String order;

    // 开始结束时间
//    private Date startTime;
//    private Date endTime;
//
//    private String startTimeStr;
//    private String endTimeStr;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

   /* public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setStartTime(String startTimeStr) {
        if (startTimeStr != null && startTimeStr.length() > 0) {
            this.startTime = DateUtil.convertTimeStringToDate(startTimeStr);
        }
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setEndTime(String endTimeStr) {
        if (endTimeStr != null && endTimeStr.length() > 0) {
            this.endTime = DateUtil.convertTimeStringToDate(endTimeStr);
        }
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }
*/
}
