package com.whim.core.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author jince
 * date: 2024/8/25 上午12:27
 * description: 文件存储服务
 */
@Component
@ConfigurationProperties(prefix = "file.storage")
@Data
public class FileStorageProperties {

    /**
     * 默认存储平台
     */
    private String defaultStorage = "local";

    /**
     * 缩略图后缀
     */
    private String thumbnailSuffix = ".min.jpg";

    /**
     * 本地存储的配置
     */
    private LocalStorageProperties local = new LocalStorageProperties("whim/file", "/file/**");

    /**
     * 其他存储平台的配置 (例如: minio, oss 等，每个平台可以有多个配置实例)
     */
    private Map<String, List<OtherStorageProperties>> otherStorage;


    @Data
    @AllArgsConstructor
    public static class LocalStorageProperties {
        private String storagePath;
        private String accessPath;
    }

    @Data
    public static class OtherStorageProperties {
        private String domain;
        private String accessKey;
        private String secretKey;
        private List<String> bucketNames;
        private String storagePath;
        private String accessPath;
    }
}


