package com.whim.core.storage;

import org.springframework.stereotype.Component;

/**
 * @author jince
 * date: 2024/8/23 下午5:45
 * description: 本地存储方式
 */
@Component("local")
public class LocalStorage implements FileStorage {
    @Override
    public void close() throws Exception {

    }
}
