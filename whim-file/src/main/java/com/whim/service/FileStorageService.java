package com.whim.service;

import com.whim.common.exception.FileStorageException;
import com.whim.core.adapter.FileAdapter;
import com.whim.core.config.FileStorageProperties;
import com.whim.core.handler.FileUploadHandler;
import com.whim.core.storage.FileInfo;
import com.whim.core.storage.FileStorage;
import com.whim.core.wrapper.FileWrapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author jince
 * date: 2024/8/21 下午4:01
 * description: 文件存储服务
 */
@Slf4j
@AllArgsConstructor
public class FileStorageService {
    private final FileStorageProperties fileStorageProperties;
    private final CopyOnWriteArrayList<FileAdapter> fileAdapter;
    private final CopyOnWriteArrayList<FileStorage> fileStorage;

    /**
     * 创建文件上传处理器
     *
     * @param file 文件
     * @return 文件上传处理器
     */
    public FileUploadHandler createFileUploadHandler(Object file) {
        FileWrapper fileWrapper = this.getFileWrapper(file);
        if (Objects.isNull(fileWrapper)) {
            throw new FileStorageException("不支持的文件类型");
        }
        return new FileUploadHandler(fileStorageProperties, fileStorage).setFileWrapper(fileWrapper);
    }

    public FileUploadHandler createFileHandler(FileInfo fileInfo) {
        return new FileUploadHandler(null, null);
    }

    /**
     * 获取文件包装类
     *
     * @param file 文件
     * @return 文件包装类
     */
    private FileWrapper getFileWrapper(Object file) {
        if (Objects.isNull(file)) {
            throw new FileStorageException("文件为空");
        }
        for (FileAdapter adapter : fileAdapter) {
            if (adapter.isSupport(file)) {
                return adapter.getFileWrapper(file);
            }
        }
        return null;
    }

}

