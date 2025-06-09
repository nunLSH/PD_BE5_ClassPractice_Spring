package com.grepp.spring.infra.error.exceptions

import com.grepp.spring.infra.response.ResponseCode
import org.slf4j.LoggerFactory

open class CommonException : RuntimeException {
    private val code: com.grepp.spring.infra.response.ResponseCode
    private var redirect = "/"
    private val log = LoggerFactory.getLogger(javaClass)

    constructor(code: com.grepp.spring.infra.response.ResponseCode) {
        this.code = code
    }

    constructor(code: com.grepp.spring.infra.response.ResponseCode, redirect: String) {
        this.code = code
        this.redirect = redirect
    }

    constructor(code: com.grepp.spring.infra.response.ResponseCode, e: Exception) {
        this.code = code
        log.error(e.message, e)
    }

    constructor(code: com.grepp.spring.infra.response.ResponseCode, e: Exception, redirect: String) {
        this.code = code
        this.redirect = redirect
        log.error(e.message, e)
    }

    fun redirect(): String {
        return redirect
    }

    fun code(): com.grepp.spring.infra.response.ResponseCode {
        return code
    }
}