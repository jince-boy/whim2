package com.whim.core.storage;

import com.whim.core.wrapper.FileWrapper;

import java.io.IOException;

/**
 * @author jince
 * date: 2024/8/21 上午11:10
 * description: 文件存储接口
 */
public interface FileStorage extends AutoCloseable {
    Boolean upload(FileWrapper fileWrapper, FileInfo fileInfo) throws IOException;
}
