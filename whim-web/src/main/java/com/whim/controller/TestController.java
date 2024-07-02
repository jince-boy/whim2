package com.whim.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaIgnore;
import com.whim.common.base.BaseController;
import com.whim.common.web.Result;
import com.whim.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author Jince
 * date: 2024/6/20 下午11:41
 * description:
 */
@RestController
@RequestMapping("/test")
@Slf4j
@RequiredArgsConstructor
public class TestController extends BaseController {
    private final FileService fileService;

    @PostMapping
    @SaIgnore
    public Result<String> test(@RequestPart("file") MultipartFile file) throws IOException {
        return Result.success("成功", fileService.uploadFile(file));
    }

    @SaCheckPermission("sys:permission:add")
    @GetMapping("/testCheckPermission")
    public Result<Void> testCheckPermission() {
        return Result.success();
    }
}
