package com.whim.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author jince
 * date: 2024/6/26 下午2:21
 * description: 用户登录DTO
 */
@Data
@Schema(name = "用户登录对象", description = "用户登录对象")
public class LoginDTO {
    @NotNull(message = "用户名不能为空")
    @Size(min = 5, max = 18, message = "用户名长度在5位到18位之间")
    @Schema(description = "用户名")
    private String username;
    @Size(min = 8, max = 18, message = "用户名长度在8位到18位之间")
    @NotNull(message = "密码不能为空")
    @Schema(description = "密码")
    private String password;
    @NotNull(message = "验证码不能为空")
    @Size(min = 5, max = 5, message = "用户名长度在5位到18位之间")
    @Schema(description = "验证码")
    private String captcha;
    @NotNull(message = "记住我不能为空")
    @Schema(description = "记住我")
    private Boolean rememberMe;
}
