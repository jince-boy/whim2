package com.whim.core.handler;

import com.whim.core.config.FileStorageProperties;
import com.whim.core.storage.FileStorage;
import com.whim.core.wrapper.FileWrapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Jince
 * date: 2024/8/21 下午11:18
 * description: 文件上传处理器，可设置上传平台，缩略图，压缩，旋转，水印等。
 */
@Slf4j
public class FileUploadHandler {
    private final FileStorageProperties fileStorageProperties;
    private final CopyOnWriteArrayList<FileStorage> fileStorage;
    private FileWrapper fileWrapper;


    public FileUploadHandler(FileStorageProperties fileStorageProperties, CopyOnWriteArrayList<FileStorage> fileStorage) {
        this.fileStorageProperties = fileStorageProperties;
        this.fileStorage = fileStorage;
    }

    public FileUploadHandler setFileWrapper(FileWrapper fileWrapper) {
        this.fileWrapper = fileWrapper;
        return this;
    }

    public FileUploadHandler upload() throws IOException {
        log.info(fileStorageProperties.getOtherStorage().get("minio").toString());
        log.info(fileStorage.toString());
        return this;
    }

}
