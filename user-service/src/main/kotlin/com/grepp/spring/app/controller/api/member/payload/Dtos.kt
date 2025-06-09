package com.grepp.spring.app.controller.api.member.payload

import com.grepp.spring.infra.annotation.NoArgsConstructor
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class SignupRequest(
    @NotBlank
    val userId:String,
    @NotBlank
    val password:String,
    @Email
    val email:String,
    @NotBlank
    val tel: String
)

@com.grepp.spring.infra.annotation.NoArgsConstructor
data class MemberDetailResponse(
    // 서버에러
//    var userId:String,
//    var email:String,
//    var tel: String

    // 서버에러 해결
    var userId: String? = null,
    var email: String? = null,
    var role: String? = null,
    var tel: String? = null
)
