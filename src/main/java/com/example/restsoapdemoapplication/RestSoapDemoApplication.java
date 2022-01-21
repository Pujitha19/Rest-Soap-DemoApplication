package com.example.restsoapdemoapplication;

import org.sds.springbootlogger.utils.InternalRestClientLoggerUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestSoapDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestSoapDemoApplication.class, args);
    }


    @Bean
    public InternalRestClientLoggerUtil getInternalRestClientLoggerUtil(){
        return new InternalRestClientLoggerUtil();
    }
}
