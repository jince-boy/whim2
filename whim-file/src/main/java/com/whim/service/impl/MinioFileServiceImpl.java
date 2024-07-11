package com.whim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whim.entity.SysFile;
import com.whim.mapper.SysFileMapper;
import com.whim.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Jince
 * date: 2024/7/11 下午11:18
 * description:
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MinioFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements FileService {
    @Override
    public SysFile uploadFile(MultipartFile file, String folderName, String description) throws Exception {
        return null;
    }

    @Override
    public boolean deleteFile(Long fileId) throws IOException {
        return false;
    }

    @Override
    public Resource getFile(Long fileId) {
        return null;
    }
}
