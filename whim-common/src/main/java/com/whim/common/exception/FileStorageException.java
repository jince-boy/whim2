package com.whim.common.exception;

/**
 * @author jince
 * date: 2024/8/23 下午3:53
 * description: 文件存储异常
 */
public final class FileStorageException extends RuntimeException {
    public FileStorageException(String message) {
        super(message);
    }
}
