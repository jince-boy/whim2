package com.whim.config;

import com.whim.common.serializer.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Jince
 * date: 2024/6/25 下午10:36
 * description: Redis配置文件
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        //设置Redis连接工厂
        template.setConnectionFactory(factory);
        FastJsonRedisSerializer<Object> objectFastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        // 使用自定义序列化和反序列化redis的value值
        template.setValueSerializer(objectFastJsonRedisSerializer);
        // Hash的key也采用StringRedisSerializer的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        // 使用自定义序列化和反序列化redis的value值
        template.setHashValueSerializer(objectFastJsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
