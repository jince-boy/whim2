package com.whim.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whim.entity.SysFile;
import com.whim.mapper.SysFileMapper;
import com.whim.service.ISysFileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author jince
 * date: 2024/8/13 下午2:50
 * description: 系统文件 SysFile 表服务实现类
 */
@Service
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements ISysFileService {
    /**
     * 根据id获取系统文件信息
     *
     * @param id 系统文件的唯一标识符
     * @return 返回对应ID的系统文件信息对象如果找不到对应的文件信息，则可能返回null
     */
    public SysFile getSysFileById(Long id) {
        return this.getById(id);
    }

    /**
     * 根据path获取系统文件信息
     *
     * @param path 系统文件的唯一标识符
     * @return 返回对应ID的系统文件信息对象如果找不到对应的文件信息，则可能返回null
     */
    public SysFile getSysFileByPath(String path) {
        LambdaQueryWrapper<SysFile> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(path), SysFile::getPath, path);
        return this.getOne(lambdaQueryWrapper);
    }

    /**
     * 添加系统文件记录
     *
     * @param sysFile 要添加的系统文件对象
     * @return 如果文件添加成功返回true，否则返回false
     */
    @Override
    public boolean addSysFile(SysFile sysFile) {
        return this.save(sysFile);
    }

    /**
     * 根据指定的ID删除系统文件信息
     *
     * @param id 文件的唯一标识符，用于定位要删除的文件
     * @return 返回一个布尔值，表示删除操作是否成功
     */
    public boolean deleteSysFileById(Long id) {
        return this.removeById(id);
    }


}
