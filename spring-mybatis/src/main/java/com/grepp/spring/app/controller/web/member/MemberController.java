package com.grepp.spring.app.controller.web.member;

import com.grepp.spring.app.controller.web.member.form.SignupForm;
import com.grepp.spring.app.model.member.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("signup")
    public String signup(SignupForm form){
        return "member/signup";
    }

    @PostMapping("signup")
    public String signup(
        @Valid SignupForm form,
        BindingResult bindingResult,
        Model model){

        if(bindingResult.hasErrors()){
            return "member/signup";
        }

        memberService.signup(form.toDto());

        return "redirect:/";
    }

}