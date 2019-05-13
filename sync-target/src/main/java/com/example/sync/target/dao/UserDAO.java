package com.example.sync.target.dao;

import com.example.sync.target.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yuming
 * @date 2019/5/12
 */
@Mapper
public interface UserDAO {

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    int batchInsert(@Param("list") List<User> list);
}