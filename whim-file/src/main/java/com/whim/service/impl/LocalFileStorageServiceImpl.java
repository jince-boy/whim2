package com.whim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whim.common.utils.IDUtils;
import com.whim.entity.SysFile;
import com.whim.mapper.SysFileMapper;
import com.whim.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author JinCe
 * date: 2024-06-30 21:26:10
 * description: 本地上传服务
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class LocalFileStorageServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements FileService {

    @Value("${file.storage.local.path}")
    private String basePath;

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        return this.uploadFile(null, file);
    }

    @Override
    public String uploadFile(String folderName, MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("上传的文件不能为空");
        }
        String targetFolder = (folderName != null && !folderName.isEmpty()) ? folderName : "default";
        Path filePath = Paths.get(this.basePath, targetFolder);

        if (!Files.exists(filePath)) {
            Files.createDirectories(filePath);
        }

        // 获取文件扩展名
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        //生成文件名称
        String fileName = IDUtils.generateUUID() + "." + fileExtension;
        Path targetLocation = filePath.resolve(fileName);

        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return this.basePath + targetFolder + "/" + fileName;
    }
}

