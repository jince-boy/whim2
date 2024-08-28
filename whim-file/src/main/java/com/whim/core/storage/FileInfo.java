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
     * 存储路径
     */
    private String path;
}
