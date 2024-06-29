package com.whim.controller;

import com.whim.common.base.BaseController;
import com.whim.service.ISysUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

/**
 * @author JinCe
 * date: 2024-06-25 21:56:39
 * description: 系统用户 SysUser 表控制层
 */
@RestController
@RequestMapping("/sysUser")
@RequiredArgsConstructor
public class SysUserController extends BaseController {
    /**
     * 服务对象
     */
    private final ISysUserService sysUserService;

}

