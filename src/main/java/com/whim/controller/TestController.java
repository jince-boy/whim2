package com.whim.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaIgnore;
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
    @SaIgnore
    public Result<Void> test() {
        return Result.success();
    }

    @SaCheckPermission("sys:permission:add")
    @GetMapping("/testCheckPermission")
    public Result<Void> testCheckPermission() {
        return Result.success();
    }
}
