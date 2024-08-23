package com.whim.core.config;

import com.whim.core.adapter.MultipartFileAdapter;
import com.whim.core.builder.FileStorageServiceBuilder;
import com.whim.service.FileStorageService;
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
        return new FileStorageServiceBuilder()
                .create()
                .addFileWrapperAdapter(new MultipartFileAdapter())
                .build();
    }
}
