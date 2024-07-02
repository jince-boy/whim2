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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
    // 本地上传目录
    @Value("${file.storage.local.path}")
    private String basePath;


    /**
     * 上传文件到本地
     *
     * @param file        MultipartFile
     * @param folderName  自定义路径
     * @param description 文件描述
     * @return SysFile
     * @throws Exception ServiceException
     */
    @Transactional
    @Override
    public SysFile uploadFile(MultipartFile file, String folderName, String description) throws Exception {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("上传的文件不能为空");
        }
        // 查看用户是否提供了的文件夹路径，如果提供了，查看前面是否有"/",确保上传文件一定是绝对路径
        String targetFolder = StringUtils.defaultIfEmpty(StringUtils.strip(folderName, "/"), "default");
        // 在basePath前加上"/"确保获取的是绝对路径
        Path absoluteBasePath = Paths.get(StringUtils.prependIfMissing(basePath, "/")).toAbsolutePath().normalize();
        Path absolutePath = absoluteBasePath.resolve(targetFolder).normalize();
        // 创建文件夹
        Files.createDirectories(absolutePath);
        String fileName = IDUtils.generateUUID();
        String fileExtension = FileUtils.getExtension(file.getOriginalFilename());
        Path targetLocation = absolutePath.resolve(fileName + "." + fileExtension).normalize();
        // 创建 SysFile 对象
        SysFile sysFile = new SysFile();
        sysFile.setName(fileName);
        sysFile.setPath(absoluteBasePath.relativize(targetLocation).toString().replace("\\", "/"));
        sysFile.setSize(file.getSize());
        sysFile.setExtension(fileExtension);
        sysFile.setFileType(file.getContentType());
        sysFile.setStorageType(StorageType.LOCAL.name());
        sysFile.setDescription(description);
        try {
            if (fileMapper.insert(sysFile) <= 0) {
                log.error("保存到数据库中失败");
                throw new ServiceException("服务器错误，请稍后重试。");
            }
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            if (!Files.exists(targetLocation) || !Files.isRegularFile(targetLocation)) {
                log.error("文件保存失败");
                throw new ServiceException("服务器错误，请稍后重试。");
            }
            return sysFile;
        } catch (Exception e) {
            log.error("文件上传失败", e);
            throw new ServiceException("服务器错误，请稍后重试。");
        }
    }
}

