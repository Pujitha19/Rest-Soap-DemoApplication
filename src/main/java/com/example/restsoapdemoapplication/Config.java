package com.example.restsoapdemoapplication;


import org.sds.springbootlogger.interceptors.ClientLoggerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


@Configuration
public class Config {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("com.example.restsoapdemoapplication.spring_boot_soap_example"); // this will serilaize and unserialize it
        return jaxb2Marshaller;
    }

    @Bean
    public SoapConfig getClient(Jaxb2Marshaller jaxb2Marshaller){

        SoapConfig soapClient = new SoapConfig();
        soapClient.setMarshaller(jaxb2Marshaller);
        soapClient.setUnmarshaller(jaxb2Marshaller);
        soapClient.setInterceptors(ClientLoggerInterceptor.getSoapClientLogger());
        return soapClient;
    }



}
