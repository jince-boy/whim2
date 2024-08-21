package com.whim.service;

import com.whim.adapter.FileWrapperAdapter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author jince
 * date: 2024/8/21 下午4:01
 * description: 文件存储服务
 */
@Slf4j
@AllArgsConstructor
public class FileStorageService {

    private final CopyOnWriteArrayList<FileWrapperAdapter> fileWrapperAdapter;

}

