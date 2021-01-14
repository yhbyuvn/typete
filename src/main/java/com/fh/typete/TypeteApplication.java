package com.fh.typete;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fh.typete.dao")
public class TypeteApplication {

    public static void main(String[] args) {
        SpringApplication.run(TypeteApplication.class, args);
    }

}
