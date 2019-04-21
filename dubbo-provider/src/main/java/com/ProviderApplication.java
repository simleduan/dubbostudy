package com;

import org.springframework.boot.SpringApplication;
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
@ImportResource("classpath:provider.xml")
public class ProviderApplication {

  public static void main(String[] args) throws InterruptedException {

    SpringApplication.run(ProviderApplication.class, args);
  }

}
