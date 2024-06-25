package com.whim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whim.mapper.SysUserMapper;
import com.whim.pojo.entity.SysUser;
import com.whim.service.ISysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jince
 * date: 2024/6/24 下午10:57
 * description: 系统用户表(SysUser)服务实现类
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Override
    public List<SysUser> getUsers() {
        return this.list();
    }
}
