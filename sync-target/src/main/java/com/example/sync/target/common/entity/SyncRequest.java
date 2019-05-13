package com.example.sync.target.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuming
 * @date 2019/5/12
 */
@Data
public class SyncRequest implements Serializable {

    private static final long serialVersionUID = 1980719760313647810L;

    /** 同步表名 */
    private String table;

    /** 同步指定日期 */
    private String date;
}
