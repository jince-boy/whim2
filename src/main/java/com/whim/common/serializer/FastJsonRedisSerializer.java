package com.whim.common.serializer;

import com.alibaba.fastjson2.JSON;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author Jince
 * date: 2024/6/25 下午10:40
 * description: 自定义redis value序列化
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
    private final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    private final Class<T> tClass;

    public FastJsonRedisSerializer(Class<T> tClass) {
        super();
        this.tClass = tClass;
    }

    @Override
    public byte[] serialize(T value) throws SerializationException {
        if (value == null) {
            return new byte[0];
        }
        return JSON.toJSONBytes(value);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);
        return JSON.parseObject(str, this.tClass);
    }
}
