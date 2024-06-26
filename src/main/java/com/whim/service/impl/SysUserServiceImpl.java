package com.whim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.base.Captcha;
import com.whim.common.core.constant.RedisKeyConstants;
import com.whim.common.helper.RedisHelper;
import com.whim.common.utils.IPUtils;
import com.whim.common.utils.StringFormatUtils;
import com.whim.mapper.SysUserMapper;
import com.whim.pojo.entity.SysUser;
import com.whim.service.ISysUserService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.TimeUnit;

/**
 * @author JinCe
 * date: 2024-06-25 21:56:39
 * description: 系统用户 SysUser 表服务实现类
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    private final RedisHelper redisHelper;

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
}

