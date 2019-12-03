package com.example.profiles.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jingzhidematong
 * @date 2019/12/3
 */
@RestController
public class HelloController {

    @Value("${com.test.profile.username}")
    private String username;


    @GetMapping(value = "/hello")
    public String hello(){

        System.out.println("username : " + username);

        return "ok";
    }

}
