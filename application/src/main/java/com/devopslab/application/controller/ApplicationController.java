package com.devopslab.application.controller;

import com.devopslab.application.dto.ApplicationInfoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/")
    public ApplicationInfoDTO index() {

        return new ApplicationInfoDTO(
                applicationName,
                "0.0.1-SNAPSHOT",
                "local"
        );

    }

}