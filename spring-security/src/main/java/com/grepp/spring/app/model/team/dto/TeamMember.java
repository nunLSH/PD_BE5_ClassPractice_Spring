package com.grepp.spring.app.model.team.dto;

import com.grepp.spring.app.model.team.code.TeamRole;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TeamMember {
    private Integer tmId;
    private Integer teamId;
    private String userId;
    private TeamRole role;
    private LocalDateTime createdAt;
    private Boolean activated;
}