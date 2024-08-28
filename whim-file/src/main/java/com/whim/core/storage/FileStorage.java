package com.whim.core.storage;

import com.whim.core.wrapper.FileWrapper;

/**
 * @author jince
 * date: 2024/8/21 上午11:10
 * description: 文件存储接口
 */
public interface FileStorage extends AutoCloseable {
    FileInfo upload(FileWrapper fileWrapper, FileInfo fileInfo);
}
