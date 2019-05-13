package com.example.sync.source.dao;

import com.example.sync.source.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author yuming
 * @date 2019/5/12
 */
@Mapper
public interface UserDAO {

    /**
     * 查询指定日期的数据
     *
     * @param date
     * @return
     */
    List<User> findByDate(@Param("date") Date date);
}