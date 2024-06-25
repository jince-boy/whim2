package com.whim.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whim.pojo.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author JinCe
 * date: 2024-06-25 21:56:38
 * description: 系统用户 SysUser 表数据库访问层
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}

