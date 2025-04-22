package com.grepp.spring.infra.feign.client.busstop.config;

import com.grepp.spring.infra.feign.error.FeignCommonException;
import feign.Response;
import feign.ResponseInterceptor;
import java.util.Collection;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

public class BusStopConfig {

    @Bean
    public ResponseInterceptor busStopInterceptor(){
        return (invocationContext, chain) -> {
            Response response = invocationContext.response();

            Collection<String> contentType = response.headers().get("content-type");
            if(contentType == null){
                return chain.next(invocationContext);
            }

            if(contentType.contains("application/xml;charset=UTF-8")){
                throw new FeignCommonException("0000", "Content-type is XML", HttpStatus.NOT_ACCEPTABLE);
            }

            return chain.next(invocationContext);
        };
    }

}