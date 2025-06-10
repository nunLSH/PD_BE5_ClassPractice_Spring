package com.grepp.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GreppMailApplication

fun main(args: Array<String>) {
    runApplication<GreppMailApplication>(*args)
}
