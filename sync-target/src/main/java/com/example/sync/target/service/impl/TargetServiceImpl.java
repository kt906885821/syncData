package com.example.sync.target.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.sync.target.common.constant.SyncTable;
import com.example.sync.target.common.constant.SyncRequest;
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
    public Integer start(String taskName, String startTime,String endTime) {
        String data = this.targetData(taskName, startTime,endTime);
        return this.save(taskName, data);
    }

    @Override
    public String targetData(String taskName, String startTime,String endTime) {
        SyncRequest syncRequest = new SyncRequest();
        syncRequest.setTaskName(taskName);
        syncRequest.setStartTime(startTime);
        syncRequest.setEndTime(endTime);
        return HttpClientUtils.send(sourceUrl, JSON.toJSONString(syncRequest));
    }

    @Override
    public Integer save(String taskName, String data) {
        if (SyncTable.SYNC_USER.equals(taskName)) {
            JSONObject jsonObject = JSONObject.parseObject(data);
            List<User> userList = JSON.parseArray(jsonObject.getString("data"), User.class);
            int row = userDAO.batchInsert(userList);
            System.out.println("新增同步数据: row = " + row);
            return row;
        }
        return 0;
    }
}
