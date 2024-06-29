package com.whim.core.auth.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jince
 * date: 2024/6/29 上午11:46
 * description:
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

