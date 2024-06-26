package com.whim.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author jince
 * date: 2024/6/26 下午2:18
 * description: 用户登录实例对象
 */
@Data
@AllArgsConstructor
@Schema(name = "登录实例")
public class LoginVO {
    @Schema(description = "token")
    private String token;
    @Schema(description = "有效时间")
    private Long expires;
}
