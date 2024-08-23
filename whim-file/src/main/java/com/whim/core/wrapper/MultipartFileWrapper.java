package com.whim.core.wrapper;

import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jince
 * date: 2024/8/23 下午2:22
 * description:
 */
@AllArgsConstructor
public class MultipartFileWrapper implements FileWrapper {
    private final MultipartFile file;

    @Override
    public InputStream getInputStream() throws IOException {
        return new BufferedInputStream(file.getInputStream());
    }
}
