package com.whim.common.utils;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Jince
 * date: 2024/6/23 上午12:00
 * description: Servlet工具类
 */
@Slf4j
public class ServletUtils {
    /**
     * 获取请求属性
     *
     * @return ServletRequestAttributes
     */
    public static ServletRequestAttributes getRequestAttributes() {
        try {
            RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
            return (ServletRequestAttributes) attributes;
        } catch (Exception e) {
            log.error("获取ServletRequestAttributes异常", e);
            return null;
        }
    }

    /**
     * 获取Request
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        try {
            return Objects.requireNonNull(getRequestAttributes()).getRequest();
        } catch (Exception e) {
            log.error("获取ServletRequest异常", e);
            return null;
        }
    }

    /**
     * 返回请求头中的语言
     *
     * @return 语言
     */
    public static String getLanguage() {
        if (StringUtils.isNotBlank(Objects.requireNonNull(getRequest()).getHeader("Accept-Language"))) {
            return getRequest().getHeader("Accept-Language");
        }
        return "en";
    }

    /**
     * 获取参数  params form-data x-www-form-urlencoded
     *
     * @param name 参数名称
     * @return 参数值
     */
    public static String getParameter(String name) {
        return Objects.requireNonNull(getRequest()).getParameter(name);
    }

    /**
     * 获取参数并赋予默认值  params form-data x-www-form-urlencoded
     *
     * @param name         参数名称
     * @param defaultValue 默认值
     * @return 参数值
     */
    public static String getParameter(String name, String defaultValue) {
        return ConvertUtils.toStr(Objects.requireNonNull(getRequest()).getParameter(name), defaultValue);
    }

    /**
     * 获取所有参数
     *
     * @param request HttpServletRequest/ServletRequest
     * @return Map 参数集合
     */
    public static Map<String, String> getParameterAll(ServletRequest request) {
        Map<String, String> params = new HashMap<>();
        for (Map.Entry<String, String[]> entry : Collections.unmodifiableMap(request.getParameterMap()).entrySet()) {
            params.put(entry.getKey(), StringUtils.join(entry.getValue(), ","));
        }
        return params;
    }

    /**
     * 获取参数并转换成Integer
     *
     * @param name 参数名称
     * @return Integer参数值
     */
    public static Integer getParameterToInt(String name) {
        return ConvertUtils.toInt(getParameter(name));
    }

    /**
     * 获取参数转换成Integer并赋予默认值
     *
     * @param name         参数名称
     * @param defaultValue 默认值
     * @return Integer 参数值
     */
    public static Integer getParameterToInt(String name, Integer defaultValue) {
        return ConvertUtils.toInt(getParameter(name), defaultValue);
    }

    /**
     * 获取参数并转换成Boolean
     *
     * @param name 参数名称
     * @return Boolean 参数值
     */
    public static Boolean getParameterToBoolean(String name) {
        return ConvertUtils.toBool(getParameter(name));
    }

    /**
     * 获取参数转换成Boolean并赋予默认值
     *
     * @param name         参数名称
     * @param defaultValue 默认值
     * @return Boolean 参数值
     */
    public static Boolean getParameterToBoolean(String name, Boolean defaultValue) {
        return ConvertUtils.toBool(getParameter(name), defaultValue);
    }

    /**
     * 获取分页页数
     *
     * @return Integer参数值
     */
    public static Integer getPageNum() {
        return getParameterToInt("pageNum", 1);
    }

    /**
     * 获取分页页数
     *
     * @param name         分页页数参数名称
     * @param defaultValue 分页页数默认值
     * @return Integer 分页页数
     */
    public static Integer getPageNum(String name, Integer defaultValue) {
        return getParameterToInt(name, defaultValue);
    }

    /**
     * 获取分页数量
     *
     * @return Integer 分页数量
     */
    public static Integer getPageSize() {
        return getParameterToInt("pageSize", 10);
    }

    /**
     * 获取分页数量
     *
     * @param name         分页数量参数名称
     * @param defaultValue 分页数量默认值
     * @return Integer 分页数量
     */
    public static Integer getPageSize(String name, Integer defaultValue) {
        return getParameterToInt(name, defaultValue);
    }

    /**
     * 将URL的参数值进行编码
     *
     * @param value 参数值
     * @return 编码后的参数值
     */
    public static String URLParamEncode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

    /**
     * 将URL的参数值进行自定义编码
     *
     * @param value  参数值
     * @param encode 自定义编码
     * @return 编码后的参数值
     */
    public static String URLParamEncode(String value, Charset encode) {
        return URLEncoder.encode(value, encode);
    }

    /**
     * 将URL编码后的参数值进行解码
     *
     * @param value 编码后的参数值
     * @return 解码后的参数值
     */
    public static String URLParamDecode(String value) {
        return URLDecoder.decode(value, StandardCharsets.UTF_8);
    }

    /**
     * 将URL编码后的参数值进行解码
     *
     * @param value  编码后的参数值
     * @param encode 自定义编码
     * @return 解码后的参数值
     */
    public static String URLParamDecode(String value, Charset encode) {
        return URLDecoder.decode(value, encode);
    }

    /**
     * 获取请求地址
     *
     * @return 请求地址
     */
    public static String getRequestURL() {
        return Objects.requireNonNull(getRequest()).getScheme() + "://" + getRequest().getServerName() + ":" + getRequest().getServerPort();
    }

}
