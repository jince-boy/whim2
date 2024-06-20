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
    private Long currentPage;
    private List<T> data;
    private Long pages;
    private Long size;
    private Long total;
}
