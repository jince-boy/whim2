package com.whim.common.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @author Jince
 * date: 2024/6/28 下午11:35
 * description:BCrypt 密码加密工具类
 */
public class BCryptUtils {
    private static final int DEFAULT_COST = 10;

    /**
     * BCrypt编码
     *
     * @param str 字符串
     * @return 编码后的字符串
     */
    public static String encode(String str) {
        return BCrypt.hashpw(str, BCrypt.gensalt(DEFAULT_COST));
    }

    /**
     * @param rawStr     原字符串
     * @param encodedStr 编码后的字符串
     * @return true正确，false不正确
     */
    public static boolean matches(String rawStr, String encodedStr) {
        return BCrypt.checkpw(rawStr, encodedStr);
    }
}
