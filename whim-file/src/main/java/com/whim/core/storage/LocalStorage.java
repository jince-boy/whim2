package com.whim.core.storage;

import com.whim.common.utils.FileUtils;
import com.whim.core.config.FileStorageProperties;
import com.whim.core.wrapper.FileWrapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

/**
 * @author jince
 * date: 2024/8/23 下午5:45
 * description: 本地存储方式
 */
@Component("local")
@Slf4j
@AllArgsConstructor
public class LocalStorage implements FileStorage {
    private final FileStorageProperties fileStorageProperties;

    @Override
    public Boolean upload(FileWrapper fileWrapper, FileInfo fileInfo) throws IOException {
        // 基础路径
        Path basePath = FileUtils.generateAbsolutePath(fileStorageProperties.getLocal().getStoragePath());
        // 上传路径
        String uploadPath = StringUtils.defaultIfEmpty(StringUtils.strip(fileInfo.getPath(), "/"), "");
        // 完整路径
        Path fullUploadPath = basePath.resolve(uploadPath).normalize();
        // 创建完整路径
        Files.createDirectories(fullUploadPath);
        // 文件名称
        String fileName = StringUtils.isEmpty(fileInfo.getFileName()) ? FileUtils.getFileName(fileWrapper.getName()) : fileInfo.getFileName();
        // 扩展名
        String extension = FileUtils.getExtension(fileWrapper.getName());
        // 完整的文件上传绝对路径
        Path filePath = fullUploadPath.resolve(fileName + "." + extension).normalize();
        // 将文件存储
        Files.copy(fileWrapper.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // 文件存储成功后，设置FileInfo的属性
        fileInfo.setCreateTime(LocalDateTime.now());
        return true;
    }

    @Override
    public void close() throws Exception {

    }
}
