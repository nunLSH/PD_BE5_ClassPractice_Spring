package com.grepp.spring.app.controller.web.urlencoded.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UrlEncodedValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}