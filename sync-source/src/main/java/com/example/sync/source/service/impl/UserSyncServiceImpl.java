package com.example.sync.source.service.impl;

import com.example.sync.source.common.entity.User;
import com.example.sync.source.dao.UserDAO;
import com.example.sync.source.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author yuming
 * @date 2019/5/12
 */
@Service
public class UserSyncServiceImpl implements SyncService<User> {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> query(Date date) {
        return userDAO.findByDate(date);
    }
}
