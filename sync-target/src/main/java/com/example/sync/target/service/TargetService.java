package com.example.sync.target.service;

/**
 * @author yuming
 * @date 2019/5/12
 */
public interface TargetService {

    /**
     * 开始同步
     *
     * @param table 同步的表
     * @param date  指定日期
     * @return
     */
    Integer start(String taskName, String date);

    /**
     * 获取指定日期的数据
     *
     * @param table 同步的表
     * @param date  指定日期
     * @return
     */
    String targetData(String taskName, String date);

    /**
     * 保存数据
     *
     * @param table 表名
     * @param data  数据
     */
    Integer save(String taskName, String data);
}
