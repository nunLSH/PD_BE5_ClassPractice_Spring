package com.grepp.spring.app.model.thymeleaf.dto;

public record ExampleDto(
    String name,
    int age,
    String subject,
    int score,
    boolean isStudent
) {

}
