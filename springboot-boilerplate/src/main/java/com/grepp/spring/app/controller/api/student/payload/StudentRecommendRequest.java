package com.grepp.spring.app.controller.api.student.payload;

import com.grepp.spring.app.model.student.code.MBTI;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record StudentRecommendRequest(
    String name,
    MBTI mbti,
    String major
) {

}
