package com.whim.adapter;

import com.whim.adapter.wrapper.FileWrapper;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author jince
 * date: 2024/8/22 上午11:38
 * description:Multipart File 包装适配器
 */
public class MultipartFileWrapperAdapter implements FileWrapperAdapter {
    @Override
    public boolean isSupport(Object file) {
        return file instanceof MultipartFile;
    }

    @Override
    public FileWrapper wrap(Object file) {
        MultipartFile multipartFile = (MultipartFile) file;

    }
}
