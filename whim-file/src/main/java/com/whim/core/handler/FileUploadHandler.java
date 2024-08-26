package com.whim.core.handler;

import com.whim.common.exception.FileStorageException;
import com.whim.core.config.FileStorageProperties;
import com.whim.core.storage.FileStorage;
import com.whim.core.wrapper.FileWrapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * @author Jince
 * date: 2024/8/21 下午11:18
 * description: 文件上传处理器，可设置上传平台，缩略图，压缩，旋转，水印等。
 */
@Slf4j
public class FileUploadHandler {
    /**
     * 文件存储配置
     */
    private final FileStorageProperties fileStorageProperties;
    /**
     * 文件存储方式
     */
    private final Map<String, FileStorage> fileStorage;
    /**
     * 当前文件包装类
     */
    private FileWrapper fileWrapper;
    /**
     * 当前存储方式
     */
    private FileStorage storage;


    public FileUploadHandler(FileStorageProperties fileStorageProperties, Map<String, FileStorage> fileStorage) {
        this.fileStorageProperties = fileStorageProperties;
        this.fileStorage = fileStorage;
        this.storage = fileStorage.get(fileStorageProperties.getDefaultStorage());
    }

    public FileUploadHandler setFileWrapper(FileWrapper fileWrapper) {
        this.fileWrapper = fileWrapper;
        return this;
    }

    public FileUploadHandler upload() throws IOException {
        this.storage.upload();
        return this;
    }

    /**
     * 设置上传路径
     *
     * @param path
     */
    public void setPath(String path) {

    }

    /**
     * 设置上传方式
     *
     * @param storageName 存储方式名称
     */
    public FileUploadHandler setStorage(String storageName) {
        FileStorage storage = fileStorage.get(storageName);
        if (Objects.isNull(storage)) {
            throw new FileStorageException("文件存储方式不存在");
        }
        this.storage = storage;
        return this;
    }

    /**
     * 设置文件上传名称
     *
     * @param fileName
     */
    public void setFileName(String fileName) {

    }

}
