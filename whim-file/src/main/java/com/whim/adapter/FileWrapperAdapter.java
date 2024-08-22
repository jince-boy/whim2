package com.whim.adapter;

import com.whim.adapter.wrapper.FileWrapper;

/**
 * @author Jince
 * date: 2024/8/22 上午12:04
 * description: 文件包装适配器接口
 */
public interface FileWrapperAdapter {
    /**
     * 是否支持该类型
     *
     * @param file 文件
     * @return 是否支持
     */
    boolean isSupport(Object file);

    /**
     * 包装
     *
     * @param file 文件
     * @return FileWrapper
     */
    FileWrapper wrap(Object file);
}
