package com.grepp.spring.controller.web.admin;

import com.grepp.spring.form.SignupForm;
import com.grepp.spring.app.model.auth.code.Role;
import com.grepp.spring.app.model.member.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {

    private final MemberService memberService;

    @GetMapping
    public String dashboard(){
        return "admin/dashboard";
    }

    @GetMapping("signup")
    public String signup(SignupForm form){
        return "admin/signup";
    }

    @PostMapping("signup")
    public String signup(@Valid SignupForm form, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "admin/signup";
        }
        memberService.signup(form.toDto(), Role.ROLE_ADMIN);
        return "redirect:/";
    }
}
