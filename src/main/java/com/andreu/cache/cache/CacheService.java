package com.andreu.cache.cache;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.io.Serializable;


@Service
@AllArgsConstructor
public class CacheService {
    private final RedisTemplate<Serializable, Serializable> redisTemplate;

    public void cache(Serializable key, Serializable value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Serializable get(Serializable key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean isFieldPresent(Serializable topKey) {
        return Boolean.TRUE.equals(redisTemplate.opsForValue().getOperations().hasKey(topKey));
    }
}
