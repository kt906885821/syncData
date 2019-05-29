package com.example.sync.source.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.sync.source.common.constant.SyncTable;
import com.example.sync.source.common.entity.SyncRequest;
import com.example.sync.source.common.entity.SyncResponse;
import com.example.sync.source.common.entity.User;
import com.example.sync.source.service.SourceService;
import com.example.sync.source.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 推送数据
 *
 * @author yuming
 * @date 2019/5/12
 */
@Service
public class SourceServiceImpl implements SourceService {

    @Autowired
    private SyncService<User> userSyncService;

    @Override
    public String push(SyncRequest syncRequest) {
        String table = syncRequest.getTable();
        String startTime = syncRequest.getStartTime();
        String endTime = syncRequest.getEndTime();
        if (SyncTable.SYNC_USER.equals(table)) {
            SyncResponse response = new SyncResponse();
            List<User> userList = userSyncService.query(table,startTime,endTime);
            response.setData(JSON.toJSONString(userList));
            if (response != null && response.equals(" ")) {
                return JSON.toJSONString(response);
            }else {
                return "传送完毕";
            }
        }
        return null;
    }

    private Date parseDateStr(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(dateStr);
    }
}
