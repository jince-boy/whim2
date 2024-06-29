package com.whim.common.exception;

/**
 * @author jince
 * date: 2024/6/26 下午3:20
 * description: 用户不存在异常
 */
public final class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
