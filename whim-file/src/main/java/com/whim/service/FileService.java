package com.whim.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whim.entity.SysFile;

import java.io.File;
import java.io.IOException;

/**
 * 系统文件(SysFile)表服务接口
 *
 * @author JinCe
 * @since 2024-06-30 21:26:09
 */
public interface FileService extends IService<SysFile> {

    SysFile uploadFile(File file,String folderName,String description) throws Exception;
}
