package com.jidai.manager.controller;

import com.jidai.manager.service.impl.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CacheService cacheService;
    @PostMapping("/1")
    private void test1() {
        Map<String, String> map = new HashMap<>();
        map.put("x32", "131234");
        map.put("231", "32211");
        cacheService.addSet("1232", map);
    }
}
