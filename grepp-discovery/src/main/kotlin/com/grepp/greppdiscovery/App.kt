package com.grepp.greppdiscovery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class GreppDiscoveryApplication

fun main(args: Array<String>) {
    runApplication<GreppDiscoveryApplication>(*args)
}
