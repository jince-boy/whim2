package com.whim.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whim.common.core.base.BaseController;
import com.whim.common.web.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "测试类")
public class TestController extends BaseController {
    @GetMapping
    @Operation(summary = "测试方法")
    public Result<Void> test() {
        return Result.success();
    }
}
