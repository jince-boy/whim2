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
 * 系统用户表(SysUser)实体类
 *
 * @author makejava
 * @since 2024-06-24 22:52:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "系统用户表")
public class SysUser extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -69468093000478860L;
    /**
     * 主键
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "主键")
    private Long id;
    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String username;
    /**
     * 密码
     */
    @Schema(description = "密码")
    private String password;
    /**
     * 头像
     */
    @Schema(description = "头像")
    private String avatar;
    /**
     * 名称
     */
    @Schema(description = "名称")
    private String name;
    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    private String email;
    /**
     * 手机号
     */
    @Schema(description = "手机号")
    private String mobile;
    /**
     * 性别
     */
    @Schema(description = "性别")
    private String gender;
    /**
     * 状态
     */
    @Schema(description = "状态")
    private String status;
}
