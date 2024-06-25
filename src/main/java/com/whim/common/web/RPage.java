package com.whim.common.web;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Jince
 * date: 2024/6/20 下午11:10
 * description: Response 分页
 */
@Data
@AllArgsConstructor
@Schema(description = "分页对象")
public class RPage<T> {
    @Schema(description = "当前页")
    private Long currentPage;
    @Schema(description = "分页数据")
    private List<T> data;
    @Schema(description = "总页数")
    private Long pages;
    @Schema(description = "每页数量")
    private Long size;
    @Schema(description = "总数量")
    private Long total;
}
