package com.hsj;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = "com.hsj.mapper")
@SpringBootApplication
public class AgorithmwebApplication {
	public static void main(String[] args ) {
		SpringApplication.run(AgorithmwebApplication.class, args);
	}

}
