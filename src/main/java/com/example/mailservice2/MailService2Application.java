package com.example.mailservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MailService2Application {

    public static void main(String[] args) {
        SpringApplication.run(MailService2Application.class, args);
    }

}
