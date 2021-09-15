package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import org.springframework.web.bind.annotation.RequestParam;

public interface StorageService {
    void decrease(Long productId, Integer count);
}
