package com.devopslab.application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public record ApplicationProperties(

        String name,
        String version,
        String environment

) {
}