package com.whim.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whim.pojo.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jince
 * date: 2024/6/24 下午10:53
 * description: 系统用户表（SysUser）数据库访问层
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
