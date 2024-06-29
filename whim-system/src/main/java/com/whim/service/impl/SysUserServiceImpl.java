package com.whim.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wf.captcha.GifCaptcha;
import com.whim.common.constant.RedisKeyConstants;
import com.whim.common.exception.CheckCaptchaException;
import com.whim.common.exception.UserNotFoundException;
import com.whim.common.exception.UserPasswordNotMatchException;
import com.whim.common.helper.RedisHelper;
import com.whim.common.utils.BCryptUtils;
import com.whim.common.utils.IPUtils;
import com.whim.common.utils.StringFormatUtils;
import com.whim.dto.LoginDTO;
import com.whim.entity.SysUser;
import com.whim.mapper.SysUserMapper;
import com.whim.service.ISysUserService;
import com.whim.vo.LoginVO;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author JinCe
 * date: 2024-06-25 21:56:39
 * description: 系统用户 SysUser 表服务实现类
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    private final RedisHelper redisHelper;

    @Override
    public LoginVO login(LoginDTO loginDTO) {
        String key = StringFormatUtils.format(RedisKeyConstants.CAPTCHA_KEY, IPUtils.getClientIpAddress(), loginDTO.getCaptcha().toLowerCase());
        if (redisHelper.hasKey(key)) {
            redisHelper.deleteObject(key);
        } else {
            log.info("验证码错误");
            throw new CheckCaptchaException("验证码错误");
        }
        SysUser user = this.getSysUserByUsername(loginDTO.getUsername().trim());
        if (Objects.isNull(user)) {
            throw new UserNotFoundException("你登录的账户不存在");
        }
        if (BCryptUtils.matches(loginDTO.getPassword(), user.getPassword())) {
            if (loginDTO.getRememberMe()) {
                StpUtil.login(user.getId());
            } else {
                StpUtil.login(user.getId(), false);
            }
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return new LoginVO(tokenInfo.getTokenValue(), tokenInfo.getTokenTimeout());
        }
        throw new UserPasswordNotMatchException("用户名或密码错误");
    }

    /**
     * 获取验证码
     *
     * @return base64 验证码
     */
    @Override
    public String getCaptcha() {
        GifCaptcha captcha = new GifCaptcha(130, 48);
        // 将验证码存入redis
        redisHelper.setObject(StringFormatUtils.format(RedisKeyConstants.CAPTCHA_KEY, IPUtils.getClientIpAddress(), captcha.text().toLowerCase()), captcha.text().toLowerCase(), 3L, TimeUnit.MINUTES);
        return captcha.toBase64();
    }

    /**
     * 通过用户名获取用户
     *
     * @param username 用户名
     * @return SysUser
     */
    @Override
    public SysUser getSysUserByUsername(String username) {
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(username), SysUser::getUsername, username);
        return this.getOne(lambdaQueryWrapper);
    }
}

