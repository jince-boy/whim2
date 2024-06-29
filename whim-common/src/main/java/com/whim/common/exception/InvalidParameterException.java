package com.whim.common.exception;

/**
 * @author jince
 * date: 2024/6/24 上午10:29
 * description: 参数异常
 */
public final class InvalidParameterException extends RuntimeException {
    public InvalidParameterException(String message) {
        super(message);
    }
}
