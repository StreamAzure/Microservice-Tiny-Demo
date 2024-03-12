package com.demo.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.stream.apis")
public class DemoTicketServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTicketServiceApplication.class, args);
    }

}
