package com.whim.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whim.pojo.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JinCe
 * date: 2024-06-25 21:56:37
 * description: 系统角色 SysRole 表数据库访问层
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 通过用户id获取角色权限标识列表
     *
     * @param userId 用户id
     * @return 角色权限标识列表
     */
    List<String> getRoleCodeByUserId(@Param("userId") Long userId);
}

