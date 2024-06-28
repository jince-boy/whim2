package com.whim.common.web;

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
public class RPage<T> {
    /**
     * 当前页
     */
    private Long currentPage;
    /**
     * 分页数据
     */
    private List<T> data;
    /**
     * 总页数
     */
    private Long pages;
    /**
     * 每页数量
     */
    private Long size;
    /**
     * 总数量
     */
    private Long total;
}
