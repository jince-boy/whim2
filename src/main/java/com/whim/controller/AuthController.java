package com.whim.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.whim.common.web.Result;
import com.whim.pojo.dto.LoginDTO;
import com.whim.pojo.vo.LoginVO;
import com.whim.service.ISysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jince
 * date: 2024/6/25 下午10:23
 * description: 用户认证控制器
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "用户认证")
public class AuthController {
    private final ISysUserService sysUserService;

    /**
     * 用户登录
     */
    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public Result<LoginVO> login(@RequestBody LoginDTO loginDTO) {
        return Result.success("登录成功", sysUserService.login(loginDTO));
    }

    /**
     * 获取验证码
     */
    @Operation(summary = "获取验证码")
    @GetMapping("/captcha")
    public Result<String> getCaptcha() {
        return Result.success("获取成功", sysUserService.getCaptcha());
    }
}
