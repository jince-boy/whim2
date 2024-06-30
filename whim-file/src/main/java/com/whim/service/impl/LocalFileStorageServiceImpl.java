package com.whim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whim.entity.SysFile;
import com.whim.mapper.SysFileMapper;
import com.whim.service.ISysFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author JinCe
 * date: 2024-06-30 21:26:10
 * description: 本地上传服务
 */
@Service
@RequiredArgsConstructor
public class LocalFileStorageServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements ISysFileService {

    @Value("${file.storage.local.path}")
    private final String path;

    @Override
    public String uploadFile(MultipartFile file) {
        return "";
    }
}

