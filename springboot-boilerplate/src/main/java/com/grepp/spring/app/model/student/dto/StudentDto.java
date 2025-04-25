package com.grepp.spring.app.model.student.dto;

import com.grepp.spring.app.model.student.code.MBTI;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class StudentDto {
    private String userId;
    private String name;
    private MBTI mbti;
    private String major;

}
