package com.grepp.spring.infra.error;

import com.grepp.spring.infra.error.exceptions.CommonException;
import com.grepp.spring.infra.error.exceptions.WebException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.grepp.spring.app.controller.web")
public class WebExceptionAdvice {

    @ExceptionHandler(WebException.class)
    public String webExceptionHandler(WebException ex, Model model){
        model.addAttribute("message", ex.code().message());
        return "error/redirect";
    }

    @ExceptionHandler(CommonException.class)
    public String commonHandler(CommonException ex, Model model){
        model.addAttribute("message", ex.code().message());
        return "error/redirect";
    }
}
