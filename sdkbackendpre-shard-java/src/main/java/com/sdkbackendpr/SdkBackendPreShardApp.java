package com.sdkbackendpr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.sdkbackendpr.mapper")
public class SdkBackendPreShardApp {
	public static void main(String[] args) {
		SpringApplication.run(SdkBackendPreShardApp.class, args);
	}

}
