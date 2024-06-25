package com.whim.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jince
 * date: 2024/6/24 下午9:25
 * description:
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI OpenApi() {
        return new OpenAPI().info(
                new Info()
                        .title("Whim")
                        .version("0.0.1")
                        .description("Whim开发接口文档")
                        .termsOfService("无")
                        .contact(new Contact().name("JinCe").email("jince_hm@163.com").url("https://www.jince.tech"))
        );
    }
}
