package com.grepp.spring.app.model.team.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Team {

    private Integer teamId;
    private String name;
    private LocalDateTime createdAt;
    private Boolean activated;

}