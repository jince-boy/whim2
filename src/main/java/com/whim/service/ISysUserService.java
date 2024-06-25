package com.whim.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whim.pojo.entity.SysUser;

import java.util.List;

/**
 * @author Jince
 * date: 2024/6/24 下午10:55
 * description: 系统用户表(SysUser)服务接口
 */
public interface ISysUserService extends IService<SysUser> {
    List<SysUser> getUsers();
}
