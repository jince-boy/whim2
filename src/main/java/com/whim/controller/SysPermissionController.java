package com.whim.controller;

import com.whim.service.ISysPermissionService;
import com.whim.common.core.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

/**
 * @author JinCe
 * date: 2024-06-25 21:56:37
 * description: 菜单权限 SysPermission 表控制层
 */
@RestController
@RequestMapping("/sysPermission")
@RequiredArgsConstructor
public class SysPermissionController extends BaseController {
    /**
     * 服务对象
     */
    private final ISysPermissionService sysPermissionService;

}

