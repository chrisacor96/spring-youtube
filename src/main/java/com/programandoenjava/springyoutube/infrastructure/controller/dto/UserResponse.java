package com.programandoenjava.springyoutube.infrastructure.controller.dto;

public record UserResponse(
        Long id,
        String firstName,
        String lastName
) {
}
