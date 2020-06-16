package org.example.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExampleServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleServiceProviderApplication.class, args);
    }

}
