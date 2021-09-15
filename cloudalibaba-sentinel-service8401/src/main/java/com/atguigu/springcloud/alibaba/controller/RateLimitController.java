package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.myhandler.CustomerBlockHandler;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handlerException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试ok", new Payment(2020L, "serial001"));
    }

    public CommonResult handlerException(BlockException e){
        return new CommonResult(444, e.getClass().getCanonicalName(), "\t 服务不可用");
    }

    @GetMapping("/rateLimit/customerBlockHander")
    @SentinelResource(value = "customerBlockHander",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException1")
    public CommonResult customerBlockHander(){
        return new CommonResult(200,"自定义限流测试ok");
    }
}
