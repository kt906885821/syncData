package com.example.sync.target.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuming
 * @date 2019/5/12
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 4636452544087521850L;

    /** 主键 */
    private Long id;

    /** 姓名 */
    private String userName;

    /** 年龄 */
    private Integer userAge;

    /** 创建日期 */
    private Date dateCreated;
}