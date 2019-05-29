package com.example.sync.source.service;

import java.util.Date;
import java.util.List;

/**
 * @author yuming
 * @date 2019/5/12
 */
public interface SyncService<T> {

    /**
     * 获取数据
     *
     * @return
     */
    List<T> query(String taskName,String startTime,String endTime);
}
