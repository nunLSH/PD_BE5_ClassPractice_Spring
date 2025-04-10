package com.grepp.spring.app.controller.api.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public record RestForm(
    Integer id,
    @Email
    String email,
    @NotBlank
    String name,
    LocalDateTime createdAt
) {

}
