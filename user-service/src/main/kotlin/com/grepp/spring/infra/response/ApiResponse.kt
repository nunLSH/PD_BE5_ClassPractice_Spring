package com.grepp.spring.infra.response

import com.grepp.spring.infra.response.ResponseCode

@JvmRecord
data class ApiResponse<T>(
    val code: String,
    val message: String,
    val data: T? = null
) {
    companion object {
        fun <T> success(data: T): ApiResponse<T> {
            return ApiResponse(com.grepp.spring.infra.response.ResponseCode.OK.code(), com.grepp.spring.infra.response.ResponseCode.OK.message(), data)
        }

        fun noContent(): ApiResponse<Unit> {
            return ApiResponse(com.grepp.spring.infra.response.ResponseCode.OK.code(), com.grepp.spring.infra.response.ResponseCode.OK.message())
        }

        @JvmStatic
        fun error(code: com.grepp.spring.infra.response.ResponseCode): ApiResponse<Unit> {
            return ApiResponse(code.code(), code.message())
        }

        fun <T> error(code: com.grepp.spring.infra.response.ResponseCode, data: T): ApiResponse<T> {
            return ApiResponse(code.code(), code.message(), data)
        }
    }
}