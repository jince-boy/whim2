package com.whim.service;

import com.whim.adapter.FileWrapperAdapter;
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
    List<FileWrapperAdapter> fileWrapperAdapters = new ArrayList<>();

    public FileStorageServiceBuilder create() {
        return this;
    }

    public FileStorageServiceBuilder addFileWrapperAdapter(FileWrapperAdapter adapter) {
        this.fileWrapperAdapters.add(null);
        return this;
    }

    public FileStorageService build() {
        return new FileStorageService(new CopyOnWriteArrayList<>(this.fileWrapperAdapters));
    }
}
