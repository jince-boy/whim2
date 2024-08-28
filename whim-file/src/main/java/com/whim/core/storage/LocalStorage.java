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
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
    public FileInfo upload(FileWrapper fileWrapper, FileInfo fileInfo) {
        // 基础路径
        Path basePath = FileUtils.generateAbsolutePath(fileStorageProperties.getLocal().getStoragePath());
        // 上传路径
        String uploadPath = StringUtils.defaultIfEmpty(StringUtils.strip(fileInfo.getPath(), "/"), "");
        // 文件名称
        String fileName = StringUtils.isEmpty(fileInfo.getFileName()) ? FileUtils.getFileName(fileWrapper.getName()) : fileInfo.getFileName();
        // 扩展名
        String extension = FileUtils.getExtension(fileWrapper.getName());
        // 完整的上传绝对路径
        Path fullUploadPath = basePath.resolve(uploadPath).resolve(fileName + "." + extension).normalize();



        log.info(fullUploadPath.toString());
        return fileInfo;
//        Path destinationPath = Paths.get(fileInfo.getPath(), fileInfo.getFileName());
//        try {
//            // 利用 Files.copy 进行文件复制
//            Files.copy(fileWrapper.getInputStream(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
//
//            log.info("File uploaded successfully: {}", destinationPath.toAbsolutePath());
//            // 更新 fileInfo 的路径信息
//            fileInfo.setPath(destinationPath.toAbsolutePath().toString());
//            return fileInfo;
//
//        } catch (IOException e) {
//            log.error("Error uploading file", e);
//            throw new RuntimeException("File upload failed", e);
//        }
    }

    @Override
    public void close() throws Exception {

    }
}
