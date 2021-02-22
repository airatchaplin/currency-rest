package com.airatchaplin.currentrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableFeignClients
@PropertySource("classpath:currency.properties")
public class CurrencyRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyRestApplication.class, args);
    }

}
