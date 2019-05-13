package com.example.sync.source.service;

import com.example.sync.source.common.entity.SyncRequest;

/**
 * @author yuming
 * @date 2019/5/12
 */
public interface SourceService {

    /**
     * 开始推送数据
     *
     * @param syncRequest 请求实体
     * @return 数据
     */
    String push(SyncRequest syncRequest);
}
