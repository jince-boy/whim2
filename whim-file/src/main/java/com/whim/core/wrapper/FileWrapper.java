package com.whim.core.wrapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author jince
 * date: 2024/8/23 下午2:22
 * description: 文件包装类接口
 */
public interface FileWrapper {
    String getName();

    String getContentType();

    Long getSize();

    /**
     * 获取文件输入流
     *
     * @return 输入流
     */
    InputStream getInputStream() throws IOException;
}
