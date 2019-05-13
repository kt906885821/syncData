package com.example.sync.source.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuming
 * @date 2019/5/12
 */
@Data
public class SyncResponse implements Serializable {

    private static final long serialVersionUID = -874417709051947827L;

    /** 同步数据 */
    private String data;
}
