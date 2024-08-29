package com.whim.core.wrapper;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jince
 * date: 2024/8/23 下午2:22
 * description: MultipartFile 包装类
 */
@Setter
@Getter
public class MultipartFileWrapper extends AbstractFileWrapper {
    private final MultipartFile file;

    public MultipartFileWrapper(MultipartFile file) {
        this.file = file;
        this.name = file.getOriginalFilename();
        this.contentType = file.getContentType();
        this.size = file.getSize();
    }

    @Override
    protected InputStream createInputStream() throws IOException {
        if (this.inputStream == null) {
            this.inputStream = new BufferedInputStream(file.getInputStream());
        }
        return this.inputStream;
    }
}
