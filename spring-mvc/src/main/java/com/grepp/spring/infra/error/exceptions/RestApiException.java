package com.grepp.spring.infra.error.exceptions;

import com.grepp.spring.infra.response.ResponseCode;

public class RestApiException extends CommonException{

    public RestApiException(ResponseCode code) {
        super(code);
    }

    public RestApiException(ResponseCode code, Exception e) {
        super(code, e);
    }
}
