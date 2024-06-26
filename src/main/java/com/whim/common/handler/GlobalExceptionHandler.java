package com.whim.common.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import com.whim.common.exception.CheckCaptchaException;
import com.whim.common.exception.InvalidParameterException;
import com.whim.common.exception.ServiceException;
import com.whim.common.exception.UserNotFoundException;
import com.whim.common.exception.UserPasswordNotMatchException;
import com.whim.common.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author jince
 * date: 2024/6/24 上午10:26
 * description: 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 业务异常处理
     */
    @ExceptionHandler(ServiceException.class)
    public Result<String> handleServiceExceptionHandler(ServiceException exception) {
        log.error(exception.getMessage());
        return Result.error(exception.getMessage());
    }

    /**
     * 参数异常处理
     */
    @ExceptionHandler(InvalidParameterException.class)
    public Result<String> handleInvalidParameterExceptionHandler(InvalidParameterException exception) {
        log.error(exception.getMessage());
        return Result.argumentError(exception.getMessage());
    }

    /**
     * 用户未登录异常
     */
    @ExceptionHandler(NotLoginException.class)
    public Result<String> handleNotLoginException(NotLoginException exception) {
        log.error(exception.getMessage());
        return Result.unauthorized("用户未认证");
    }

    /**
     * 用户没有权限
     */
    @ExceptionHandler(NotPermissionException.class)
    public Result<String> handleNotPermissionException(NotPermissionException exception) {
        log.error(exception.getMessage());
        return Result.error(HttpStatus.FORBIDDEN, "用户没有权限");
    }

    /**
     * 验证码异常
     */
    @ExceptionHandler(CheckCaptchaException.class)
    public Result<String> handleCheckCaptchaException(CheckCaptchaException exception) {
        log.error(exception.getMessage());
        return Result.argumentError(exception.getMessage());
    }

    /**
     * 用户名密码错误
     */
    @ExceptionHandler(UserPasswordNotMatchException.class)
    public Result<String> handleUserPasswordNotMatchException(UserPasswordNotMatchException exception) {
        log.error(exception.getMessage());
        return Result.unauthorized(exception.getMessage());
    }

    /**
     * 用户不存在
     */
    @ExceptionHandler(UserNotFoundException.class)
    public Result<String> handleUserNotFoundException(UserNotFoundException exception) {
        log.error(exception.getMessage());
        return Result.error(HttpStatus.NOT_FOUND, exception.getMessage());
    }
}
