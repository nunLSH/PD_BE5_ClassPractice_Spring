package com.grepp.spring.app.model.member.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MemberInfo {

    private String userId;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime loginDate;
    private LocalDateTime modifyDate;
    private LocalDateTime leaveDate;
    private LocalDateTime rentableDate = LocalDateTime.now();
}
