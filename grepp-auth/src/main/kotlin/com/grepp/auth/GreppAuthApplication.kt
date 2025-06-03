package com.grepp.auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GreppAuthApplication

fun main(args: Array<String>) {
    runApplication<GreppAuthApplication>(*args)
}
