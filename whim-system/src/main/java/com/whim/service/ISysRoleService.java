package com.whim.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whim.entity.SysRole;

import java.util.List;

/**
 * 系统角色(SysRole)表服务接口
 *
 * @author JinCe
 * @since 2024-06-25 21:56:38
 */
public interface ISysRoleService extends IService<SysRole> {
    /**
     * 通过用户id获取角色权限标识列表
     *
     * @param userId 用户id
     * @return 角色权限标识列表
     */
    List<String> getRoleCodeByUserId(Long userId);
}
