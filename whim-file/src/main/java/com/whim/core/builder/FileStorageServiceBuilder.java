package com.whim.core.builder;

import com.whim.core.adapter.FileAdapter;
import com.whim.core.adapter.MultipartFileAdapter;
import com.whim.core.config.FileStorageProperties;
import com.whim.core.storage.FileStorage;
import com.whim.core.storage.LocalStorage;
import com.whim.core.storage.MinioStorage;
import com.whim.core.storage.OssStorage;
import com.whim.service.FileStorageService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Jince
 * date: 2024/8/22 上午1:01
 * description:用于创建 {@link FileStorageService} 实例的构建器类。
 */
public class FileStorageServiceBuilder {
    private final FileStorageProperties fileStorageProperties;
    private final List<FileAdapter> fileAdapters = new ArrayList<>();
    private final List<FileStorage> fileStorages = new ArrayList<>();

    /**
     * 构造方法
     * 默认添加的操作放在构造函数中
     */
    public FileStorageServiceBuilder(FileStorageProperties fileStorageProperties) {
        // 获取配置
        this.fileStorageProperties = fileStorageProperties;
        // 默认添加的适配器
        this.fileAdapters.add(new MultipartFileAdapter());
        // 默认添加的存储方式
        this.fileStorages.add(new LocalStorage());
        this.fileStorages.add(new OssStorage());
        this.fileStorages.add(new MinioStorage());
    }

    /**
     * 添加文件适配器
     *
     * @param adapter 适配器
     * @return FileStorageServiceBuilder
     */
    public FileStorageServiceBuilder addFileAdapter(FileAdapter adapter) {
        this.fileAdapters.add(adapter);
        return this;
    }

    /**
     * 添加存储方式
     *
     * @param storage 存储方式
     * @return FileStorageServiceBuilder
     */
    public FileStorageServiceBuilder addFileStorage(FileStorage storage) {
        this.fileStorages.add(storage);
        return this;
    }

    /**
     * 构建 FileStorageService
     *
     * @return FileStorageService
     */
    public FileStorageService build() {
        CopyOnWriteArrayList<FileAdapter> fileAdapters = new CopyOnWriteArrayList<>(this.fileAdapters);
        CopyOnWriteArrayList<FileStorage> fileStorages = new CopyOnWriteArrayList<>(this.fileStorages);
        FileStorageService service = new FileStorageService(fileStorageProperties, fileAdapters, fileStorages);
        // 清空列表，防止 build 重复调用时产生错误
        this.fileAdapters.clear();
        this.fileStorages.clear();
        return service;
    }
}
