package com.andreu.cache.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.io.Serializable;

@Configuration
public class RedisTemplateConfig {
    @Bean
    public RedisTemplate<Serializable, Serializable> redisTemplate(RedisConnectionFactory factory) {
        var template = new RedisTemplate<Serializable, Serializable>();
        template.setKeySerializer(new JdkSerializationRedisSerializer());
        template.setConnectionFactory(factory);
        return template;
    }
}
