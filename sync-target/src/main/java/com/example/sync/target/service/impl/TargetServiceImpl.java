package com.example.sync.target.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.sync.target.common.constant.SyncTable;
import com.example.sync.target.common.entity.SyncRequest;
import com.example.sync.target.common.entity.User;
import com.example.sync.target.common.util.HttpClientUtils;
import com.example.sync.target.dao.UserDAO;
import com.example.sync.target.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuming
 * @date 2019/5/12
 */
@Service
public class TargetServiceImpl implements TargetService {

    @Autowired
    private UserDAO userDAO;

    @Value("${sync.source.url}")
    private String sourceUrl;

    @Override
    public Integer start(String table, String date) {
        String data = this.pull(table, date);
        return this.save(table, data);
    }

    @Override
    public String pull(String table, String date) {
        SyncRequest syncRequest = new SyncRequest();
        syncRequest.setTable(table);
        syncRequest.setDate(date);
        return HttpClientUtils.send(sourceUrl, JSON.toJSONString(syncRequest));
    }

    @Override
    public Integer save(String table, String data) {
        if (SyncTable.SYNC_USER.equals(table)) {
            JSONObject jsonObject = JSONObject.parseObject(data);
            List<User> userList = JSON.parseArray(jsonObject.getString("data"), User.class);
            int row = userDAO.batchInsert(userList);
            System.out.println("新增同步数据: row = " + row);
            return row;
        }
        return 0;
    }
}
