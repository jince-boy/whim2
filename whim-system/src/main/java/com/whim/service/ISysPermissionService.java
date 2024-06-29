package com.whim.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whim.entity.SysPermission;

import java.util.List;

/**
 * 菜单权限(SysPermission)表服务接口
 *
 * @author JinCe
 * @since 2024-06-25 21:56:37
 */
public interface ISysPermissionService extends IService<SysPermission> {
    /**
     * 通过用户id获取权限标识列表
     *
     * @param userId 用户Id
     * @return 权限标识列表
     */
    List<String> getPermissionCodeByUserId(Long userId);
}
