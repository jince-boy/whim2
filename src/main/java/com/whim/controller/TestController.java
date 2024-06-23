package com.whim.controller;

import com.whim.common.core.base.BaseController;
import com.whim.common.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jince
 * date: 2024/6/20 下午11:41
 * description:
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController extends BaseController {
    @GetMapping
    public Result<Void> test() {
        return Result.success();
    }
}
