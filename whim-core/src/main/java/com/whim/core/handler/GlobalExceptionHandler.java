package com.whim.core.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import com.whim.common.exception.CheckCaptchaException;
import com.whim.common.exception.InvalidParameterException;
import com.whim.common.exception.ServiceException;
import com.whim.common.exception.UserNotFoundException;
import com.whim.common.exception.UserPasswordNotMatchException;
import com.whim.common.web.Result;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jince
 * date: 2024/6/24 上午10:26
 * description: 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    // 兜底异常处理器
    @ExceptionHandler(Throwable.class)
    public Result<String> handleGeneralException(Throwable e) {
        log.error("Throwable异常:{}", e.getMessage());
        return Result.error(HttpStatus.INTERNAL_SERVER_ERROR, "服务器内部错误，请稍后再试");
    }

    /**
     * 请求方式错误
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("不支持'{}'请求", e.getMethod());
        return Result.error(HttpStatus.METHOD_NOT_ALLOWED, "请求方式错误");
    }

    /**
     * 参数验证异常
     */
    @ExceptionHandler(BindException.class)
    public Result<String> handleBindException(BindException exception) {
        List<String> collect = exception.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        log.error(String.join("; ", collect));
        return Result.error(StringUtils.join(collect, ";"));
    }

    /**
     * 参数验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> collect = exception.getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        log.error(String.join("; ", collect));
        return Result.error(StringUtils.join(collect, ";"));
    }

    /**
     * 参数验证异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<String> handleConstraintViolationException(ConstraintViolationException exception) {
        List<String> collect = exception.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        log.error(String.join("; ", collect));
        return Result.error(StringUtils.join(collect, ";"));
    }

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
