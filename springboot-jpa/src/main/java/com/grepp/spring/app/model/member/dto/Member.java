package com.grepp.spring.app.model.member.dto;

import com.grepp.spring.app.model.auth.code.Role;
import lombok.Data;

@Data
public class Member {

    private String userId;
    private String password;
    private String email;
    private Role role;
    private String tel;
    private MemberInfo info;
    private Boolean activated;
}
