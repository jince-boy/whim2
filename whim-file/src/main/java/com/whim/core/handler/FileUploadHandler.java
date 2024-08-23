package com.whim.core.handler;

import com.whim.core.wrapper.FileWrapper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author Jince
 * date: 2024/8/21 下午11:18
 * description: 文件上传处理器
 */
@Setter
@Getter
@Slf4j
public class FileUploadHandler {
    private FileWrapper fileWrapper;

    public FileUploadHandler setFileWrapper(FileWrapper fileWrapper) {
        this.fileWrapper = fileWrapper;
        return this;
    }

    public FileUploadHandler upload() throws IOException {
        log.info(fileWrapper.getInputStream().toString());
        return this;
    }

}
