package com.whim.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jince
 * date: 2024/6/27 下午9:24
 * description: 文件配置类
 */
@Configuration
public class FileConfig {
    //本地存储位置
    @Value("${file.storage.location}")
    private String storageLocation;

    /**
     * 提供存储位置为一个Bean
     *
     * @return 存储位置路径字符串
     */
    @Bean
    public String storageLocation() {
        return this.storageLocation;
    }
}
