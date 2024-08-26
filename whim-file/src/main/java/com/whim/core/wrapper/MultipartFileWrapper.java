package com.whim.core.wrapper;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jince
 * date: 2024/8/23 下午2:22
 * description: MultipartFile 包装类
 */
public class MultipartFileWrapper implements FileWrapper {
    private final MultipartFile file;
    private String name;
    private String contentType;
    private InputStream inputStream;
    private Long size;

    public MultipartFileWrapper(MultipartFile file) {
        this.file = file;

    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new BufferedInputStream(file.getInputStream());
    }
}
