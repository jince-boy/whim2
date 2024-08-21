package com.whim.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaIgnore;
import com.whim.common.base.BaseController;
import com.whim.common.web.Result;
import com.whim.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    private final FileStorageService fileStorageService;


    @PostMapping
    @SaIgnore
    public Result<Void> test(@RequestParam("file") MultipartFile file) throws Exception {
//        fileStorageService.file(file).;
        return null;
    }

    @DeleteMapping
    @SaIgnore
    public Result<Boolean> test(@RequestParam("fileId") Long fileId) throws IOException {
//        return Result.success("删除成功", fileService.deleteFile(fileId));
        return null;
    }

    @GetMapping("/file/{*filePath}")
    @SaIgnore
    public ResponseEntity<Resource> tests(@PathVariable String filePath) throws Exception {
//        return Result.file(fileService.getFile(filePath));
        return null;
    }

    @SaCheckPermission("sys:permission:add")
    @GetMapping("/testCheckPermission")
    public Result<Void> testCheckPermission() {
        return Result.success();
    }
}
