package com.devopslab.application.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private final StringRedisTemplate redisTemplate;

    public RedisService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Long incrementarRequisicoes() {
        return redisTemplate.opsForValue().increment("devops-lab:requests");
    }

    public String buscarRequisicoes() {
        String valor = redisTemplate.opsForValue().get("devops-lab:requests");

        return valor != null ? valor : "0";
    }
}