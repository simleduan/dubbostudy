package com;

import com.study.config.ProviderConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan("com.study.api.service.impl")
@ImportAutoConfiguration(ProviderConfiguration.class)
public class ProviderApplication {

  public static void main(String[] args) throws InterruptedException {

    SpringApplication.run(ProviderApplication.class, args);
  }

}
