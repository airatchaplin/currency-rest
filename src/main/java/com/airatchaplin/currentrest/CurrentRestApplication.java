package com.airatchaplin.currentrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableFeignClients
@PropertySource("classpath:currency.properties")
public class CurrentRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrentRestApplication.class, args);
    }

}
