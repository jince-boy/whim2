package com.whim.common.core.base;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

/**
 * @author Jince
 * date: 2024/6/19 下午11:05
 * description: 控制器基类，格式化转换时间格式
 */
public class BaseController {
    /**
     * 时间格式
     */
    private static final String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"
    };

    /**
     * 将Date的时间转换成LocalDateTime
     */
    public LocalDateTime parseLocalDateTime(Object str) {
        if (Objects.isNull(str)) {
            return null;
        }
        try {
            Date date = DateUtils.parseDate(str.toString(), parsePatterns);
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 转换时间
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(parseLocalDateTime(text));
            }
        });
    }
}
