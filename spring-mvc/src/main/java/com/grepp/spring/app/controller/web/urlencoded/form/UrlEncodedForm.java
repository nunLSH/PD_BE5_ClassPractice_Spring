package com.grepp.spring.app.controller.web.urlencoded.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UrlEncodedForm {
    private String userId;
    private String password;
    private String email;
    private String tel;

}
