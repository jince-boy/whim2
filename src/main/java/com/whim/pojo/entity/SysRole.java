package com.whim.pojo.entity;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.whim.common.core.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author JinCe
 * date: 2024-06-25 21:56:37
 * description: 系统角色 SysRole 实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "系统角色")
public class SysRole extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -58615235008737989L;
    /**
     * 主键
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "主键")
    private Long id;
    /**
     * 角色名称
     */
    @Schema(description = "角色名称")
    private String name;
    /**
     * 角色权限编码
     */
    @Schema(description = "角色权限编码")
    private String code;
    /**
     * 角色描述
     */
    @Schema(description = "角色描述")
    private String description;
    /**
     * 状态
     */
    @Schema(description = "状态")
    private String status;
}
