package com.whim.controller;

import com.whim.common.core.base.BaseController;
import com.whim.common.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

/**
 * @author Jince
 * date: 2024/6/20 下午11:41
 * description:
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController extends BaseController {
    @GetMapping
    public Result<LinkedHashMap<String, String>> test(String a) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("a", "格式错误");
        map.put("b", "长度不对");
        log.info("123");
        return Result.argumentError(map);
    }
}
