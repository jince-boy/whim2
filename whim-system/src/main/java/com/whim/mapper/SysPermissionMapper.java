package com.whim.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whim.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JinCe
 * date: 2024-06-25 21:56:37
 * description: 菜单权限 SysPermission 表数据库访问层
 */
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    /**
     * 通过用户id获取权限标识列表
     * @param userId 用户id
     * @return 权限标识列表
     */
    List<String> getPermissionCodeByUserId(@Param("userId") Long userId);
}

