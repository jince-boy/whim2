package com.whim.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whim.pojo.entity.SysFile;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author JinCe
 * date: 2024-06-27 22:03:31
 * description: 系统文件 SysFile 表数据库访问层
 */
@Mapper
public interface SysFileMapper extends BaseMapper<SysFile> {

}

