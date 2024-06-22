package com.whim.common.utils;

import org.slf4j.MDC;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * 用于在MDC（映射诊断上下文）中管理Trace ID的工具类。
 */
public class TraceIdUtils {
    public static final String TRACE_ID = "traceId";

    /**
     * 生成一个新的Trace ID。
     *
     * @return 一个新的Trace ID
     */
    public static String generateTraceId() {
        return IdUtils.generateUUID();
    }

    /**
     * 在MDC中设置Trace ID。
     *
     * @param traceId 要设置的Trace ID
     */
    public static void setTraceId(String traceId) {
        MDC.put(TRACE_ID, traceId);
    }

    /**
     * 从MDC中获取当前的Trace ID。
     *
     * @return 当前的Trace ID，如果没有设置则返回null
     */
    public static String getTraceId() {
        return MDC.get(TRACE_ID);
    }

    /**
     * 从MDC中移除Trace ID。
     */
    public static void removeTraceId() {
        MDC.remove(TRACE_ID);
    }

    /**
     * 包装一个Callable任务以传递MDC上下文。
     *
     * @param callable 要包装的任务
     * @param context  要传递的MDC上下文
     * @param <T>      任务的返回类型
     * @return 包装后的Callable
     */
    public static <T> Callable<T> wrap(final Callable<T> callable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            setTraceIdIfAbsent();
            try {
                return callable.call();
            } finally {
                MDC.clear();
            }
        };
    }

    /**
     * 包装一个Runnable任务以传递MDC上下文。
     *
     * @param runnable 要包装的任务
     * @param context  要传递的MDC上下文
     * @return 包装后的Runnable
     */
    public static Runnable wrap(final Runnable runnable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            setTraceIdIfAbsent();
            try {
                runnable.run();
            } finally {
                MDC.clear();
            }
        };
    }

    /**
     * 如果MDC中尚未设置Trace ID，则设置Trace ID。
     */
    private static void setTraceIdIfAbsent() {
        if (getTraceId() == null) {
            setTraceId(generateTraceId());
        }
    }

    /**
     * 管理Trace ID设置和移除的上下文管理器。
     */
    public static class TraceIdContext implements AutoCloseable {
        public TraceIdContext(String traceId) {
            setTraceId(traceId);
        }

        @Override
        public void close() {
            removeTraceId();
        }
    }
}
