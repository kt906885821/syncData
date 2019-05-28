package com.example.sync.source.controller;

import
import com.example.sync.source.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuming
 * @date 2019/5/12
 */
@RestController
@RequestMapping("sync/source")
public class SourceController {

    @Autowired
    private SourceService sourceService;

    @PostMapping("/start")
    public String start(@RequestBody SyncRequest syncRequest) {
        return sourceService.push(syncRequest);
    }
}
