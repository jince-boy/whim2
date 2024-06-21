package com.whim.common.utils;

import org.slf4j.MDC;

/**
 * @author Jince
 * date: 2024/6/21 下午11:21
 * description: TraceId生成工具类
 */
public class TraceIdUtils {
    public final static String TRACE_ID = "traceId";

    /**
     * 生成TraceId
     *
     * @return TraceId
     */
    public static String generateTraceId() {
        String uuid = IdUtils.generateUUID();
        MDC.put(TRACE_ID, uuid);
        return uuid;
    }



}
