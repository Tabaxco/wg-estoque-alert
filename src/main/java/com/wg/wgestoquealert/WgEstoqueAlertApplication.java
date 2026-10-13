package com.wg.wgestoquealert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WgEstoqueAlertApplication {

    public static void main(String[] args) {
        SpringApplication.run(WgEstoqueAlertApplication.class, args);
    }
}