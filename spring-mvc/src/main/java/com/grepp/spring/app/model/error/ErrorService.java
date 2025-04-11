package com.grepp.spring.app.model.error;

import com.grepp.spring.infra.error.exceptions.RestApiException;
import com.grepp.spring.infra.error.exceptions.WebException;
import com.grepp.spring.infra.response.ResponseCode;
import org.springframework.stereotype.Service;

@Service
public class ErrorService {
    // service 안에서 WebException 을 던지는 경우
    public void webException(){
        throw new WebException(ResponseCode.BAD_REQUEST);
    }

    // service 안에서 RestApiException 을 던지는 경우
    public void restApiException(){
        throw new RestApiException(ResponseCode.BAD_REQUEST);
    }
}