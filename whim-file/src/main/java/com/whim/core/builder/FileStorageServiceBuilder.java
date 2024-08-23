package com.whim.core.builder;

import com.whim.core.adapter.FileAdapter;
import com.whim.core.storage.FileStorage;
import com.whim.service.FileStorageService;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Jince
 * date: 2024/8/22 上午1:01
 * description:用于创建 {@link FileStorageService} 实例的构建器类。
 */
@Setter
@Getter
public class FileStorageServiceBuilder {
    List<FileAdapter> fileAdapters = new ArrayList<>();
    List<FileStorage> fileStorages = new ArrayList<>();

    public FileStorageServiceBuilder create() {
        return this;
    }

    /**
     * 添加文件适配器
     *
     * @param adapter 适配器
     * @return FileStorageServiceBuilder
     */
    public FileStorageServiceBuilder addFileWrapperAdapter(FileAdapter adapter) {
        this.fileAdapters.add(adapter);
        return this;
    }

    /**
     * 构建 FileStorageService
     *
     * @return FileStorageService
     */
    public FileStorageService build() {
        return new FileStorageService(new CopyOnWriteArrayList<>(this.fileAdapters));
    }
}
