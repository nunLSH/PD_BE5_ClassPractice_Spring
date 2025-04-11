package com.grepp.spring.app.controller.api.multipart;

import com.grepp.spring.app.controller.api.multipart.form.MultipartForm;
import com.grepp.spring.app.model.multipart.MultipartService;
import com.grepp.spring.infra.error.exceptions.CommonException;
import com.grepp.spring.infra.response.ApiResponse;
import com.grepp.spring.infra.response.ResponseCode;
import jakarta.validation.Valid;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("multipart")
@Slf4j
public class MultipartController {

    private final MultipartService multipartService;

    @PostMapping("upload")
    public ResponseEntity<ApiResponse<?>> upload(
        @Valid MultipartForm form) {
        log.info("multiPartFile : {} ", form.files()
        );

        try {
            multipartService.upload(form);
        } catch (IOException e) {
            throw new CommonException(ResponseCode.INTERNAL_SERVER_ERROR, e);
        }
        return ResponseEntity.ok(ApiResponse.noContent());
    }

}