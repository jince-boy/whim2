package com.whim.manager;

import com.whim.enums.StorageType;
import com.whim.service.FileService;
import com.whim.service.impl.LocalFileServiceImpl;
import com.whim.service.impl.MinioFileServiceImpl;
import com.whim.service.impl.OssFileServiceImpl;
import com.whim.service.impl.QiniuFileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jince
 * date: 2024/7/10 下午11:28
 * description:
 */
@Service
public class FileServiceManager {
    private final Map<StorageType, FileService> fileServiceMap = new HashMap<>();

    @Autowired
    public FileServiceManager(List<FileService> fileServices) {
        for (FileService fileService : fileServices) {
            if (fileService instanceof LocalFileServiceImpl) {
                fileServiceMap.put(StorageType.LOCAL, fileService);
            } else if (fileService instanceof OssFileServiceImpl) {
                fileServiceMap.put(StorageType.OSS, fileService);
            } else if (fileService instanceof QiniuFileServiceImpl) {
                fileServiceMap.put(StorageType.QINIU, fileService);
            } else if (fileService instanceof MinioFileServiceImpl) {
                fileServiceMap.put(StorageType.MINIO, fileService);
            }
        }
    }

    public FileService getFileService(StorageType type) {
        return fileServiceMap.get(type);
    }
}