package com.whim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whim.mapper.SysUserMapper;
import com.whim.pojo.entity.SysUser;
import com.whim.service.ISysUserService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

/**
 * @author JinCe
 * date: 2024-06-25 21:56:39
 * description: 系统用户 SysUser 表服务实现类
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}

