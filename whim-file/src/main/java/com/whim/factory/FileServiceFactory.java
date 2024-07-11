package com.whim.factory;


import com.whim.common.helper.SpringHelper;
import com.whim.enums.StorageType;
import com.whim.service.FileService;
import com.whim.service.impl.LocalFileServiceImpl;
import com.whim.service.impl.MinioFileServiceImpl;
import com.whim.service.impl.OssFileServiceImpl;
import com.whim.service.impl.QiniuFileServiceImpl;

/**
 * @author Jince
 * date: 2024/7/10 下午11:28
 * description: 文件服务工厂
 */
public class FileServiceFactory {
    public FileService createFileService(StorageType type) {
        return switch (type) {
            case LOCAL -> SpringHelper.getBean(LocalFileServiceImpl.class);
            case OSS -> SpringHelper.getBean(OssFileServiceImpl.class);
            case QINIU -> SpringHelper.getBean(QiniuFileServiceImpl.class);
            case MINIO -> SpringHelper.getBean(MinioFileServiceImpl.class);
        };

    }
}
