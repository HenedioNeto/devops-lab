package com.devopslab.application.controller;

import com.devopslab.application.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    private static final Logger logger =
            LoggerFactory.getLogger(RedisController.class);

    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/redis/increment")
    public String incrementar() {

        System.out.println("TESTE REDIS CONTROLLER");

        logger.info("Incrementing Redis request counter");

        Long valor = redisService.incrementarRequisicoes();

        logger.info("Redis request counter is now {}", valor);

        return "Requisições registradas no Redis: " + valor;
    }

    @GetMapping("/redis/count")
    public String contar() {

        logger.info("Reading Redis request counter");

        return "Requisições registradas no Redis: "
                + redisService.buscarRequisicoes();
    }
}