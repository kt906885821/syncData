package com.example.sync.target.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuming
 * @date 2019/5/12
 */

public class SyncRequest implements Serializable {

    private static final long serialVersionUID = 1980719760313647810L;

    /** 同步表名 */
    private String taskName;

    /** 同步指定日期 */
    private String date;

    //开始日期
    private Integer startTime;
    //结束日期

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    private Integer endTime;
}
