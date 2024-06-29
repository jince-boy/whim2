package com.whim.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author jince
 * date: 2024/6/26 下午2:21
 * description: 用户登录DTO
 */
@Data
public class LoginDTO {
    @NotNull(message = "用户名不能为空")
    @Size(min = 5, max = 18, message = "用户名长度在5位到18位之间")
    private String username;
    @Size(min = 8, max = 18, message = "密码长度在8位到18位之间")
    @NotNull(message = "密码不能为空")
    private String password;
    @NotNull(message = "验证码不能为空")
    @Size(min = 5, max = 5, message = "用户名长度在5位到18位之间")
    private String captcha;
    @NotNull(message = "记住我不能为空")
    private Boolean rememberMe;
}
