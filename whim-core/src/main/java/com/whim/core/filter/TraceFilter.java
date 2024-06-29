package com.whim.core.filter;

import com.whim.common.utils.TraceIdUtils;
import io.micrometer.common.util.StringUtils;
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
 * date: 2024/6/22 下午10:57
 * description:用于在请求期间追踪Trace ID的过滤器。确保每个请求都有唯一的Trace ID以便更好的日志记录和追踪。
 */
@Slf4j
public class TraceFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String traceId = request.getHeader(TraceIdUtils.TRACE_ID);

        if (StringUtils.isBlank(traceId)) {
            traceId = TraceIdUtils.generateTraceId();
        }

        try (TraceIdUtils.TraceIdContext traceIdContext = new TraceIdUtils.TraceIdContext(traceId)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
