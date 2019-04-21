package com;

import com.study.config.ConsumerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan("com.study.api.service")
@ImportAutoConfiguration(ConsumerConfiguration.class)
public class WebApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(WebApplication.class, args);
    }
}