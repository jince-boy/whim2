package com.whim.common.exception;

/**
 * @author jince
 * date: 2024/6/24 上午10:25
 * description: 业务异常类
 */
public final class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }
}
