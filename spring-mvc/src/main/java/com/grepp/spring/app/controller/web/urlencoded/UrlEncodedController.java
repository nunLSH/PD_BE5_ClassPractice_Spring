package com.grepp.spring.app.controller.web.urlencoded;

import com.grepp.spring.app.controller.web.urlencoded.form.UrlEncodedForm;
import com.grepp.spring.app.controller.web.urlencoded.validator.UrlEncodedValidator;
import com.grepp.spring.app.model.error.ErrorService;
import com.grepp.spring.app.model.urlencoded.dto.UrlEncodedDto;
import com.grepp.spring.infra.error.exceptions.WebException;
import com.grepp.spring.infra.response.ResponseCode;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// NOTE 01 @Controller
// 1. 해당 클래스를 bean으로 등록
// 2. @RequestMapping : 요청 URL과 Controller method 를 매핑
// 3. @GetMapping, @PostMapping... : 지정된 Http Method 와 URL 을 Controller 의 method 와 매핑
// 4. @RequestParam : format 이 x-www-form-urlEncoded 인 요청파라미터를
//                    Controller 의 매개변수에 매핑
// 5. @ModelAttribute : 요청파라미터를 메서드의 매개변수에 선언한 Form 객체에 매핑
//                    Model 객체의 attribute 에 Form 객체를 자동으로 추가
@Controller
@RequestMapping("form")
@Slf4j
@RequiredArgsConstructor
public class UrlEncodedController {

    private final ErrorService errorService;

    // SLF4J : Simple Logging Facade for Java
    // logging : TRACE > DEBUG > INFO > WARN > ERROR > FATAL

    // NOTE 2 : Controller 메서드 반환타입
    // 1. String : view 경로
    // 2. void   : 요청 url 을 view 경로로 지정
    // 3. ModelAndView :
    //        model : Controller 에서 view 로 전달할 데이터를 저장하는 객체
    //        view  : view 의 경로

    // model 의 속성명을 지정
    // model 에 form 객체를 바인드 하는 시점에
    // 검증, 포멧팅 등의 작업을 수행
    @InitBinder("urlEncodedForm")
    private void urlEncodedBinder(WebDataBinder binder){
        binder.addValidators(new UrlEncodedValidator());
    }

    @GetMapping
    public String form(UrlEncodedForm form){
        log.debug("form  메서드");
        // forward
        return "spring/form";
    }

    @PostMapping
    public String form(
        // 암묵적인 @ModelAttribute
        @Valid
        UrlEncodedForm form,
        BindingResult bindingResult,
        Model model){

        log.info("model : {}", model);
        log.info("form : {}" , form);
        log.info("bindingResult : {}" , bindingResult);

        if (bindingResult.hasErrors()) {
            return "spring/form";
        }

        UrlEncodedDto dto = new UrlEncodedDto(
            form.getUserId(),
            form.getEmail(),
            form.getTel());

        model.addAttribute("dto", dto);
        return "spring/result";
    }

    @PostMapping("modelandview")
    public ModelAndView modelAndView(UrlEncodedForm form){
        ModelAndView mav = new ModelAndView();

        UrlEncodedDto dto = new UrlEncodedDto(
            form.getUserId(),
            form.getEmail(),
            form.getTel());

        mav.addObject("dto", dto);
        mav.setViewName("spring/result");
        return mav;
    }

    // NOTE 03 : @PathVariable
    @PostMapping("path/{id}")
    public String pathVariable(
        @PathVariable()
        String id,
        @RequestParam
        String email,
        String tel,
        LocalDateTime createdAt,
        Model model
    ){
        log.info("createdAt : {} ",  createdAt);
        model.addAttribute("dto",
            new UrlEncodedDto(id, email, tel));
        return "spring/result";
    }

    @PostMapping("session/regist")
    public String registSession(
        UrlEncodedForm form,
        HttpSession session,
        RedirectAttributes redirectAttributes
    ){
        redirectAttributes.addAttribute("attr","welcome");
        session.setAttribute("principal", form);
        return "redirect:/form/session/result";
    }

    @GetMapping("session/result")
    public String sessionResult(
        @SessionAttribute(name = "principal")
        UrlEncodedForm principal
    ){
        log.info("sessionAttribute : {}", principal);
        return "spring/session";
    }

    @GetMapping("cookie/regist")
    public String registCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("server_cookie", "this_is_server_cookie");
        response.addCookie(cookie);
        return "spring/cookie";
    }

    @GetMapping("error")
    public String error(){
        //throw new WebException(ResponseCode.BAD_REQUEST);
        errorService.webException();
        return "";
    }
}