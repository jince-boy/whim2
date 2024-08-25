package com.whim.core.storage;

import org.springframework.stereotype.Component;

/**
 * @author jince
 * date: 2024/8/23 下午5:45
 * description: Minio存储方式
 */
@Component("minio")
public class MinioStorage implements FileStorage {
    @Override
    public void close() throws Exception {

    }
}
