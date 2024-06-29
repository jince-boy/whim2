package com.whim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whim.entity.SysRole;
import com.whim.mapper.SysRoleMapper;
import com.whim.service.ISysRoleService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author JinCe
 * date: 2024-06-25 21:56:38
 * description: 系统角色 SysRole 表服务实现类
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    private final SysRoleMapper sysRoleMapper;

    /**
     * 通过用户id获取角色权限标识列表
     *
     * @param userId 用户id
     * @return 角色权限标识列表
     */
    @Override
    public List<String> getRoleCodeByUserId(Long userId) {
        return sysRoleMapper.getRoleCodeByUserId(userId);
    }
}

