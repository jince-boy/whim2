package com.whim.core.storage;

import lombok.Data;

/**
 * @author Jince
 * date: 2024/8/24 下午10:10
 * description: 文件信息
 */
@Data
public class FileInfo {
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 原始文件名称
     */
    private String originalFilename;
    /**
     * 存储路径
     */
    private String path;
    /**
     * 文件大小
     */
    private Long size;
    /**
     * 文件扩展名
     */
    private String extension;
    /**
     * 文件MIME类型
     */
    private String contentType;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 存储平台
     */
    private String storagePlatform;


}
