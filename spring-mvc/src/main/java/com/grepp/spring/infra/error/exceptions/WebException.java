package com.grepp.spring.infra.error.exceptions;

import com.grepp.spring.infra.response.ResponseCode;

public class WebException extends CommonException{

    public WebException(ResponseCode code) {
        super(code);
    }

    public WebException(ResponseCode code, Exception e) {
        super(code, e);
    }
}
