package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "-----testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "-----testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "testblockHandler")
    public String testHotKey(@RequestParam(value = "hotKey", required = false) String hotKey,
                             @RequestParam(value = "anyKey", required = false) String anyKey){
        return "Hot Key：" + hotKey;
    }

    public String testblockHandler(String hotKey, String anyKey, BlockException e){
        return "Hot Key blockHandler";
    }
}
