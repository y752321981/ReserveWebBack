package com.jidai.manager.controller;

import com.jidai.manager.service.impl.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CacheService cacheService;
    @PostMapping("/1")
    private void test1() {
        cacheService.add("123", "24");
    }
}
