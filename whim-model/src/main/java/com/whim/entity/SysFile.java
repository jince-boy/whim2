package com.whim.entity;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.whim.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;

/**
 * @author JinCe
 * date: 2024-06-27 22:03:31
 * description: 系统文件 SysFile 实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysFile extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -89281209078779164L;
    /**
     * 主键
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 文件名称
     */
    private String name;
    /**
     * 文件地址
     */
    private String path;
    /**
     * 文件大小
     */
    private Long size;
    /**
     * 文件扩展名
     */
    private String extension;
    /**
     * 文件的MIME类型（如image/png, application/pdf）
     */
    private String fileType;
    /**
     * 存储类型（如local, minio）
     */
    private String storageType;
    /**
     * 文件描述
     */
    private String description;
}
