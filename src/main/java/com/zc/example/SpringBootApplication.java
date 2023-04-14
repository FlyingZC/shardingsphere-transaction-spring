package com.zc.example;

import com.zc.example.config.TransactionConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

@org.springframework.boot.autoconfigure.SpringBootApplication
@MapperScan("com.zc.example.mapper")
@Import(TransactionConfiguration.class)
public class SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }
}
