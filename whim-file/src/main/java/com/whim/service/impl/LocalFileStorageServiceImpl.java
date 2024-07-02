package com.whim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whim.common.exception.ServiceException;
import com.whim.common.utils.FileUtils;
import com.whim.common.utils.IDUtils;
import com.whim.entity.SysFile;
import com.whim.enums.StorageType;
import com.whim.mapper.SysFileMapper;
import com.whim.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
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
    private final SysFileMapper fileMapper;

    @Value("${file.storage.local.path}")
    private String basePath;


    @Transactional
    @Override
    public SysFile uploadFile(File file, String folderName, String description) throws Exception {
        if (FileUtils.isEmpty(file)) {
            throw new IllegalArgumentException("上传的文件不能为空");
        }
        String targetFolder = (folderName != null && !folderName.isEmpty()) ? folderName : "default";
        // 获取绝对路径
        Path basePathAbsolute = Paths.get(this.basePath).toAbsolutePath().normalize();
        Path filePath = basePathAbsolute.resolve(targetFolder).normalize();
        log.info(filePath.toString());
        // 1. 准备文件元数据
        if (!Files.exists(filePath)) {
            Files.createDirectories(filePath);
        }
        String fileName = IDUtils.generateUUID();
        String fileExtension = FileUtils.getExtension(file.getName());
        Path targetLocation = filePath.resolve(fileName + "." + fileExtension).normalize();
        // 2. 创建 SysFile 对象
        SysFile sysFile = new SysFile();
        sysFile.setName(fileName);
        sysFile.setPath(targetLocation.toString().replace("\\", "/"));
        sysFile.setSize(file.length());
        sysFile.setExtension(fileExtension);
        sysFile.setFileType(Files.probeContentType(file.toPath()));
        sysFile.setStorageType(StorageType.LOCAL.name());
        sysFile.setDescription(description);
        // 3. 插入数据库
        if (fileMapper.insert(sysFile) <= 0) {
            log.error("保存到数据库中失败");
            throw new ServiceException("服务器错误，请稍后重试。");
        }
        // 4. 复制文件
        Files.copy(file.toPath(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        // 5. 验证文件复制是否成功
        if (!Files.exists(targetLocation) || !Files.isRegularFile(targetLocation)) {
            log.error("文件保存失败");
            throw new ServiceException("服务器错误，请稍后重试。");
        }
        return sysFile;
    }
}

