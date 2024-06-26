package com.whim.common.auth.config;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jince
 * date: 2024/6/25 下午5:04
 * description: 认证鉴权排除地址
 */
@Getter
public enum ExcludePathConstants {
    AUTH_CAPTCHA("/auth/captcha", "验证码"),
    AUTH_LOGIN("/auth/login", "用户登录"),
    FAVICON_PATH("/favicon.ico", "favicon.ico"),
    ;
    private final String path;
    private final String description;

    ExcludePathConstants(String path, String description) {
        this.path = path;
        this.description = description;
    }

    /**
     * 获取所有的枚举
     *
     * @return List<String>
     */
    public static List<String> getAllEnumDetails() {
        List<String> enumDetails = new ArrayList<>();
        for (ExcludePathConstants myEnum : ExcludePathConstants.values()) {
            enumDetails.add(myEnum.getPath());
        }
        return enumDetails;
    }
}
