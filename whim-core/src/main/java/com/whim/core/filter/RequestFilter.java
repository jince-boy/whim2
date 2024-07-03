package com.whim.core.filter;

import com.whim.common.utils.IPUtils;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author Jince
 * date: 2024/6/22 下午11:57
 * description: 全局请求过滤器
 */
@Slf4j
public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("IP地址为:[ {} ]的设备通过[ {} ]方法请求了路由:{ {} }", IPUtils.getClientIpAddress(request), request.getMethod(), request.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
