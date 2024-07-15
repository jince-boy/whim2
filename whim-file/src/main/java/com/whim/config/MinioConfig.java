package com.whim.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jince
 * date: 2024/7/16 下午10:58
 * description: Minio配置文件
 */
@Configuration
public class MinioConfig {
    @Value("${file.storage.minio.endpoint}")
    private String minioEndpoint;
    @Value("${file.storage.minio.access-key}")
    private String minioAccessKey;
    @Value("${file.storage.minio.secret-key}")
    private String minioSecretKey;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(minioEndpoint)
                .credentials(minioAccessKey, minioSecretKey)
                .build();
    }
}
