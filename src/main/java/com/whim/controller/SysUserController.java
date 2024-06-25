package com.whim.controller;

import com.whim.common.core.base.BaseController;
import com.whim.common.web.Result;
import com.whim.pojo.entity.SysUser;
import com.whim.service.ISysUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jince
 * date: 2024/6/24 下午11:01
 * description:
 */
@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "系统用户")
public class SysUserController extends BaseController {
    private final ISysUserService sysUserService;

    @GetMapping
    public Result<List<SysUser>> getUsers() {
        return Result.success("获取成功", sysUserService.getUsers());
    }
}
