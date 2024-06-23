package com.whim.config;

import com.whim.common.filter.RequestFilter;
import com.whim.common.filter.TraceFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @author Jince
 * date: 2024/6/22 下午11:49
 * description:过滤器配置类
 */
@Configuration
public class FilterConfig {
    /**
     * 全局请求过滤器
     */
    @Bean
    public FilterRegistrationBean<RequestFilter> createRequestFilterRegistrationBean() {
        FilterRegistrationBean<RequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestFilter());
        registrationBean.setName("RequestFilter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
        return registrationBean;
    }

    /**
     * MDC链路追踪过滤器
     */
    @Bean
    public FilterRegistrationBean<TraceFilter> createTraceFilterRegistrationBean() {
        FilterRegistrationBean<TraceFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new TraceFilter());
        registrationBean.setName("TraceFilter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registrationBean;
    }

}
