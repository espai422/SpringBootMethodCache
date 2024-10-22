package com.andreu.cache.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
@Aspect
public final class CacheAspect {
    private final CacheService cacheService;

    @Around("@annotation(com.andreu.cache.cache.Cached)")
    public Serializable cache(ProceedingJoinPoint joinPoint) {
        try {
            var signature = joinPoint.getSignature().toLongString().split(" ")[1];
            var args = serializableArgs(joinPoint.getArgs());
            var key = new Key(signature, args).toString();
            Serializable result;
            if (cacheService.isFieldPresent(key)) {
                log.info("Result found in Cache");
                result = cacheService.get(key);
            } else {
                log.info("Result not found in Cache");
                result = (Serializable) joinPoint.proceed();
                cacheService.cache(key, result);
            }
            return result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private List<Serializable> serializableArgs(Object[] args) {
        return Arrays.stream(args)
                .map(this::castObjectToSerializable)
                .toList();
    }

    private Serializable castObjectToSerializable(Object obj) {
        if (obj instanceof Serializable serializable) {
            return serializable;
        }
        throw new RuntimeException(obj + "is not serializable");
    }
}

@AllArgsConstructor
@Data
class Key implements Serializable {
    @Serial
    private static final long serialVersionUID = -4498965084227764950L;

    private final String signature;
    private final List<Serializable> args;
}
