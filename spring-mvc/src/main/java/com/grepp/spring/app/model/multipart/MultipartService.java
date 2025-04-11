package com.grepp.spring.app.model.multipart;

import com.grepp.spring.app.controller.api.multipart.form.MultipartForm;
import com.grepp.spring.infra.error.exceptions.RestApiException;
import com.grepp.spring.infra.response.ResponseCode;
import com.grepp.spring.infra.util.file.FIleUtil;
import jakarta.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Slf4j
public class MultipartService {
    public void upload(MultipartForm form) {
        FIleUtil util = new FIleUtil();

        try{
        util.upload(form.files(), "test");
        } catch (IOException e){
            throw new RestApiException(ResponseCode.INTERNAL_SERVER_ERROR, e);
        }
    }
}
