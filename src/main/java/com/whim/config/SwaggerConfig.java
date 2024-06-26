package com.whim.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

/**
 * @author Jince
 * date: 2024/6/24 下午9:25
 * description:
 */
@Configuration
@Slf4j
public class SwaggerConfig {
    @Value("${project.name}")
    private final String title = "Whim";
    @Value("${project.version}")
    private String version;
    @Value("${project.url}")
    private String contactUrl = "https://www.jince.tech";

    @Bean
    public OpenAPI OpenApi() {
        String description = "Whim开发接口文档";
        String termsOfService = "无";
        String contactName = "JinCe";
        String contactEmail = "jince_hm@163.com";
        return new OpenAPI().info(
                new Info()
                        .title(title)
                        .version(version)
                        .description(description)
                        .termsOfService(termsOfService)
                        .contact(new Contact().name(contactName).email(contactEmail).url(contactUrl))
        );
    }
}
