package com.whim.core.wrapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author jince
 * date: 2024/8/28 下午5:07
 * description: 文件包装类抽象类
 */
@Getter
@Setter
public abstract class AbstractFileWrapper implements FileWrapper {
    protected String name;
    protected String contentType;
    protected InputStream inputStream;
    protected Long size;

    @Override
    public InputStream getInputStream() throws IOException {
        if (this.inputStream == null) {
            this.inputStream = createInputStream();
        }
        return this.inputStream;
    }

    protected abstract InputStream createInputStream() throws IOException;
}
