package com.devopslab.application.dto;

public record ApplicationInfoDTO(
        String application,
        String version,
        String environment
) {
}