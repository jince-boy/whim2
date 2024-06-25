package com.whim.controller;


import com.whim.service.ISysRoleService;
import com.whim.common.core.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author JinCe
 * date: 2024-06-25 21:56:38
 * description: 系统角色 SysRole 表控制层
 */
@RestController
@RequestMapping("/sysRole")
@RequiredArgsConstructor
@Tag(name = "SysRoleController")
public class SysRoleController extends BaseController {
    /**
     * 服务对象
     */
    private final ISysRoleService sysRoleService;

}

