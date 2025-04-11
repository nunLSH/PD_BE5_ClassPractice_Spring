package com.grepp.spring.app.controller.api.multipart;

import com.grepp.spring.app.controller.api.multipart.form.MultipartForm;
import com.grepp.spring.app.model.multipart.MultipartService;
import com.grepp.spring.infra.response.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("multipart")
@Slf4j
public class MultipartController {

    private final MultipartService multipartService;

    @PostMapping("upload")
    public ResponseEntity<ApiResponse<?>> upload(
        @Valid MultipartForm form){
        log.info("multipartFile : {}", form.files());

        multipartService.upload(form);
        return ResponseEntity.ok(ApiResponse.noContent());
    }
}
