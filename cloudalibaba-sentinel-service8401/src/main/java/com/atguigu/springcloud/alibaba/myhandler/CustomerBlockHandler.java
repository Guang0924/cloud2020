package com.atguigu.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException e){
        return new CommonResult(333,"自定义限流处理信息，handlerException1");
    }

    public static CommonResult handlerException2(BlockException e){
        return new CommonResult(444,"自定义限流处理信息，handlerException2");
    }
}
