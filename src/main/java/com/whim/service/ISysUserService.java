package com.whim.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whim.pojo.dto.LoginDTO;
import com.whim.pojo.entity.SysUser;
import com.whim.pojo.vo.LoginVO;

/**
 * 系统用户(SysUser)表服务接口
 *
 * @author JinCe
 * @since 2024-06-25 21:56:39
 */
public interface ISysUserService extends IService<SysUser> {
    /**
     * 用户登录
     *
     * @param loginDTO 登录实体
     * @return LoginVO
     */
    LoginVO login(LoginDTO loginDTO);

    /**
     * 获取验证码
     *
     * @return base64 验证码
     */
    String getCaptcha();

    /**
     * 通过用户名获取用户
     *
     * @param username 用户名
     * @return SysUser
     */
    SysUser getSysUserByUsername(String username);
}
