package com.grepp.spring.app.controller.api;

import com.grepp.spring.app.controller.api.form.RestForm;
import com.grepp.spring.app.controller.api.payload.RestPayload;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.text.DateFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@Slf4j
public class RestApiController {

    // content-type : application/json

    @GetMapping("test")
    // @ResponseBody
    public RestPayload test(RestForm form){
        log.info("form : {}", form);
        OffsetDateTime now = OffsetDateTime.now();
        return new RestPayload(1, "aaa@aaa.com", now, now.toEpochSecond());
    }

}
