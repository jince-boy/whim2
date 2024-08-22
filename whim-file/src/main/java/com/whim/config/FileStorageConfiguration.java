package com.whim.config;

import com.whim.service.FileStorageService;
import com.whim.service.FileStorageServiceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jince
 * date: 2024/8/22 上午12:19
 * description: 文件存储配置
 */
@Configuration
public class FileStorageConfiguration {
    @Bean
    public FileStorageService createFileStorageService() {
        return new FileStorageServiceBuilder().create().addFileWrapperAdapter().build();
    }
}
