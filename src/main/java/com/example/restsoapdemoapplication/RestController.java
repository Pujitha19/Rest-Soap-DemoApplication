package com.example.restsoapdemoapplication;

import com.example.restsoapdemoapplication.spring_boot_soap_example.GetUserRequest;
import com.example.restsoapdemoapplication.spring_boot_soap_example.GetUserResponse;
import com.example.restsoapdemoapplication.spring_boot_soap_example.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.client.core.SoapActionCallback;


import java.util.Arrays;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SoapConfig soapConfig;

    Logger log = LoggerFactory.getLogger(RestController.class);

    private String restUrl = "http://localhost:8070/";
    private String soapUrl = "http://localhost:8091/";


    @GetMapping("rest/get")
    public ResponseEntity<String> getmethod(){
        ResponseEntity<String> post =restTemplate.getForEntity(restUrl+"/get",String.class);
        return post;
    }

    @PostMapping("/rest/post")
    public ResponseEntity<String> posted(@RequestBody Employee employee){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee,headers);
        ResponseEntity<String> post =restTemplate.postForEntity(restUrl+"/post", employee, String.class);
        return post;
    }
    @PostMapping("/soap/post")
    public ResponseEntity<GetUserResponse> SoapPost(@RequestBody GetUserRequest request){
       GetUserResponse getUserResponse=(GetUserResponse) soapConfig.getWebServiceTemplate().marshalSendAndReceive("http://localhost:8091/soapWS", request);
        return ResponseEntity.ok(getUserResponse) ;
    }

}


