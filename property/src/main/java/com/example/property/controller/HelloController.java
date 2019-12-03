package com.example.property.controller;

import com.example.property.config.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 三种不同的方式 获取配置文件中的内容
 * @author jingzhidematong
 * @date 2019/12/3
 */
@RestController
public class HelloController {

    @Autowired
    private Environment environment;

    @Value("${param}")
    private String param;

    @Value("${company.age}")
    private Integer age;

    @Autowired
    private MyConfig myConfig;

    @GetMapping(value = "/hello")
    public String hello(){
        String port = environment.getProperty("server.port");

        String username = myConfig.getUsername();
        Integer age1 = myConfig.getAge();

        System.out.println("part = " + port + " ,param = " + param + " ,age = " + age + " ,username = " + username + " ,age1 = " + age1);


        return "ok";
    }


}
