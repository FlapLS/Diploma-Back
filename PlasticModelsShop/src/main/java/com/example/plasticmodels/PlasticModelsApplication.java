package com.example.plasticmodels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class PlasticModelsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlasticModelsApplication.class, args);
    }

}
