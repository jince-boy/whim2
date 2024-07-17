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
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
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
public class LocalFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements FileService {
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
        Path absoluteBasePath = FileUtils.generateAbsolutePath(this.basePath);
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
            // 将文件存储
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            if (!Files.exists(targetLocation) || !Files.isRegularFile(targetLocation)) {
                log.error("文件保存失败");
                throw new ServiceException("服务器错误，请稍后重试。");
            }
            return sysFile;
        } catch (Exception e) {
            log.error("文件上传报错", e);
            throw new ServiceException("服务器错误，请稍后重试。");
        }
    }

    /**
     * 删除本地文件
     *
     * @param fileId 文件id
     * @return true删除成功，false删除失败
     */
    @Transactional
    @Override
    public boolean deleteFile(Long fileId) {
        SysFile sysFile = this.getById(fileId);
        if (sysFile == null) {
            throw new IllegalArgumentException("文件id不存在");
        }
        try {
            // 首先删除数据库记录
            if (!this.removeById(sysFile.getId())) {
                log.error("文件数据删除失败，fileId: {}", fileId);
                throw new ServiceException("服务器错误，请稍后重试。");
            }
            // 尝试删除文件
            Path filePath = FileUtils.generateAbsolutePath(this.basePath).resolve(sysFile.getPath()).normalize();
            if (Files.exists(filePath)) {
                try {
                    Files.delete(filePath);
                } catch (IOException e) {
                    log.error("文件删除失败，路径: {}", filePath, e);
                    throw new ServiceException("服务器错误，请稍后重试。");
                }
            } else {
                log.info("文件不存在，仅删除了数据库记录。文件路径: {}", filePath);
            }
            return true;
        } catch (Exception e) {
            log.error("删除文件过程中发生错误，fileId: {}", fileId, e);
            throw new ServiceException("服务器错误，请稍后重试。");
        }
    }

    /**
     * 从本地存储中根据文件ID获取文件.
     *
     * @param fileId 文件的ID
     * @return 代表文件的Resource
     */
    @Transactional(readOnly = true)
    @Override
    public Resource getFile(Long fileId) {
        SysFile sysFile = this.getById(fileId);
        if (sysFile == null) {
            throw new IllegalArgumentException("文件id不存在");
        }
        try {
            // 确定文件的路径
            Path filePath = Paths.get(StringUtils.prependIfMissing(this.basePath, "/")).toAbsolutePath().resolve(sysFile.getPath()).normalize();
            // 检查文件是否存在且为常规文件
            if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
                Resource resource = new UrlResource(filePath.toUri());
                // 检查资源是否存在且可读
                if (resource.exists() && resource.isReadable()) {
                    return resource;
                } else {
                    throw new ServiceException("文件不可读或不存在");
                }
            } else {
                throw new ServiceException("文件不存在");
            }
        } catch (MalformedURLException e) {
            log.error("检索文件时发生错误，fileId: {}", fileId, e);
            throw new ServiceException("服务器错误，请稍后重试。");
        }
    }
//    public Resource getFile()
}

