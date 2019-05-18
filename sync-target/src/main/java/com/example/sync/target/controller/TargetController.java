package com.example.sync.target.controller;

import com.example.sync.target.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yuming
 * @date 2019/5/12
 */
@RestController
@RequestMapping("sync/target")
public class TargetController {

    @Autowired
    private TargetService targetService;

    /**
     * 传入指定同步数据的日期
     * 调用方式:
     * 访问http://127.0.0.1:9002/sync/target/start?table=sync_user&date=2019-05-12
     * 即获取sync_user在2019年05月12日创建的数据
     *
     * @param date 日期格式:yyyy-MM-dd
     * @return 同步的数据数量
     */
    @GetMapping("/start")
    public Integer init(@RequestParam String taskName, @RequestParam String date) {
        return targetService.start(taskName, date);
    }
}
