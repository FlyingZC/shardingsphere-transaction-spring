package com.zc.example.controller;

import com.zc.example.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {
    
    @Autowired
    OrderService orderService;
    
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    
    @GetMapping("/count")
    public String count(@RequestParam(value = "table") String table) {
        Long countNum = orderService.countTable(table);
        log.info("count num: {}", countNum);
        return "countNum=" + countNum;
    }
}
