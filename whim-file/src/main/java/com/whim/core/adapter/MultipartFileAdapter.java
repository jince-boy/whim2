package com.whim.core.adapter;

import com.whim.core.wrapper.FileWrapper;
import com.whim.core.wrapper.MultipartFileWrapper;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author jince
 * date: 2024/8/22 上午11:38
 * description:Multipart File 包装适配器
 */
public class MultipartFileAdapter implements FileAdapter {
    @Override
    public boolean isSupport(Object file) {
        return file instanceof MultipartFile;
    }

    public FileWrapper getFileWrapper(Object file) {
        MultipartFile multipartFile = (MultipartFile) file;
        return new MultipartFileWrapper(multipartFile);
    }
}
