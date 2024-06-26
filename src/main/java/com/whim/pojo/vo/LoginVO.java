package com.whim.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author jince
 * date: 2024/6/26 下午2:18
 * description: 用户登录实例对象
 */
@Data
@AllArgsConstructor
public class LoginVO {
    private String token;
    private Long expires;
}
