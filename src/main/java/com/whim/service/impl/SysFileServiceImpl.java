package com.whim.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whim.mapper.SysFileMapper;
import com.whim.pojo.entity.SysFile;
import com.whim.service.ISysFileService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

/**
 * @author JinCe
 * date: 2024-06-27 22:03:31
 * description: 系统文件 SysFile 表服务实现类
 */
@Service
@RequiredArgsConstructor
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements ISysFileService {

}

