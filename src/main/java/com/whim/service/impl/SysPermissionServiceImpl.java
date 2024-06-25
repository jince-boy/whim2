package com.whim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whim.mapper.SysPermissionMapper;
import com.whim.pojo.entity.SysPermission;
import com.whim.service.ISysPermissionService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author JinCe
 * date: 2024-06-25 21:56:37
 * description: 菜单权限 SysPermission 表服务实现类
 */
@Service
@RequiredArgsConstructor
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {
    private final SysPermissionMapper sysPermissionMapper;

    /**
     * 通过用户id获取权限标识列表
     *
     * @param userId 用户Id
     * @return 权限标识列表
     */
    @Override
    public List<String> getPermissionCodeByUserId(Long userId) {
        return sysPermissionMapper.getPermissionCodeByUserId(userId);
    }
}

