package com.devopslab.application.controller;

import com.devopslab.application.config.ApplicationProperties;
import com.devopslab.application.dto.ApplicationInfoDTO;
import com.devopslab.application.dto.HelloResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    private final ApplicationProperties properties;

    public ApplicationController(ApplicationProperties properties) {
        this.properties = properties;

        if (true) {
            throw new RuntimeException("TESTE DE ROLLBACK");
        }
    }

    @GetMapping("/")
    public ApplicationInfoDTO applicationInfo() {

        logger.info("Application information requested");

        return new ApplicationInfoDTO(
                properties.name(),
                properties.version(),
                properties.environment()
        );
    }

    @GetMapping("/hello")
    public HelloResponseDTO hello() {

        logger.info("Hello endpoint requested");

        return new HelloResponseDTO(
                "Welcome to DevOps Lab!"
        );
    }
}