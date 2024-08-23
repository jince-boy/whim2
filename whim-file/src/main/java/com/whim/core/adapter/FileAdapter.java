package com.whim.core.adapter;


import com.whim.core.wrapper.FileWrapper;

/**
 * @author Jince
 * date: 2024/8/22 上午12:04
 * description: 文件包装适配器接口
 */
public interface FileAdapter {
    /**
     * 是否支持该类型
     *
     * @param file 文件
     * @return 是否支持
     */
    boolean isSupport(Object file);

    /**
     * 获取文件包装类
     *
     * @param file 文件
     * @return 文件包装类
     */
    FileWrapper getFileWrapper(Object file);
}
