package com.whim.common.utils;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * @author Jince
 * date: 2024/6/28 下午11:50
 * description: Id生成工具类
 */
public class IDUtils {
    private static final SecureRandom secureRandom = new SecureRandom();

    /**
     * 生成UUID
     *
     * @return UUID string
     */
    public static String generateUUID() {
        UUID uuid = generateSecureUUID();
        return uuid.toString().replace("-", "");
    }

    /**
     * 获取UUID
     *
     * @return UUID
     */
    private static UUID generateSecureUUID() {
        byte[] randomBytes = new byte[16];
        secureRandom.nextBytes(randomBytes);
        randomBytes[6] &= 0x0F;  // 设置版本号为4
        randomBytes[6] |= 0x40;  // 设置为随机UUID
        randomBytes[8] &= 0x3F;  // 设置Variant标识
        randomBytes[8] |= (byte) 0x80;  // 设置为随机UUID
        return UUID.nameUUIDFromBytes(randomBytes);
    }
}
