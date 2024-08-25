package com.whim.core.storage;

import org.springframework.stereotype.Component;

/**
 * @author jince
 * date: 2024/8/23 下午5:45
 * description: 阿里OSS存储方式
 */
@Component("oss")
public class OssStorage implements FileStorage {
    @Override
    public void close() throws Exception {

    }
}
