package com.whim.config;

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
