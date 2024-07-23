package com.whim.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whim.entity.SysFile;

/**
 * 系统文件(SysFile)表服务接口
 *
 * @author JinCe
 * @since 2024-06-30 21:26:09
 */
public interface ISysFileService extends IService<SysFile> {
    /**
     * 根据id获取系统文件信息
     *
     * @param id 系统文件的唯一标识符
     * @return 返回对应ID的系统文件信息对象如果找不到对应的文件信息，则可能返回null
     */
    SysFile getSysFileById(Long id);

    /**
     * 根据path获取系统文件信息
     *
     * @param path 系统文件的唯一标识符
     * @return 返回对应ID的系统文件信息对象如果找不到对应的文件信息，则可能返回null
     */
    SysFile getSysFileByPath(String path);

    /**
     * 添加系统文件记录
     *
     * @param sysFile 要添加的系统文件对象
     * @return 如果文件添加成功返回true，否则返回false
     */
    boolean addSysFile(SysFile sysFile);

    /**
     * 根据指定的ID删除系统文件信息
     *
     * @param id 文件的唯一标识符，用于定位要删除的文件
     * @return 返回一个布尔值，表示删除操作是否成功
     */
    boolean deleteSysFileById(Long id);
}
