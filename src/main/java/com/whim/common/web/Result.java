package com.whim.common.web;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Jince
 * date: 2024/6/19 下午11:46
 * description: Result统一响应工具类
 */
@Data
public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String message;
    private T data;
    private Boolean status;

    private Result(T data) {
        this.data = data;
    }

    public Result<T> setResult(Integer code, Boolean status, String message) {
        this.setCode(code);
        this.setStatus(status);
        this.setMessage(message);
        return this;
    }

    /**
     * 成功响应
     */
    public static <T> Result<T> success() {
        return new Result<T>(null).setResult(HttpStatus.OK.value(), true, "成功");
    }

}
