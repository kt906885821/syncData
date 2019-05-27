package com.example.sync.target.common.constant;

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
    private String startTime;
    //结束日期


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    private String endTime;
}
