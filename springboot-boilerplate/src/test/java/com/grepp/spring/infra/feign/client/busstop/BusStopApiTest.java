package com.grepp.spring.infra.feign.client.busstop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BusStopApiTest {

    @Autowired
    BusStopApi busStopApi;

    @Value("bus-stop.apikey")
    String apiKey;

    @Test
    public void feignTest(){
        System.out.println(busStopApi.getBusStop("6274784e696c6563373162656f584d",
            1,5));
    }

}