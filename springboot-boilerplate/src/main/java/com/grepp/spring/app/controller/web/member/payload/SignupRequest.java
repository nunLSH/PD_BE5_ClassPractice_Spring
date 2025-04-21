package com.grepp.spring.app.controller.web.member.payload;

import com.grepp.spring.app.model.member.dto.MemberDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupRequest {
    
    @NotBlank
    private String userId;
    @NotBlank
    @Size(min = 4, max = 10)
    private String password;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 8, max = 14)
    private String tel;
    
    public MemberDto toDto(){
        MemberDto memberDto = new MemberDto();
        memberDto.setUserId(userId);
        memberDto.setPassword(password);
        memberDto.setEmail(email);
        memberDto.setTel(tel);
        return memberDto;
    }
}
