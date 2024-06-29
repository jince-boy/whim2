package com.whim.common.exception;

/**
 * @author jince
 * date: 2024/6/26 下午3:20
 * description: 用户名或密码错误异常
 */
public final class UserPasswordNotMatchException extends RuntimeException{
    public UserPasswordNotMatchException(String message) {
        super(message);
    }
}
