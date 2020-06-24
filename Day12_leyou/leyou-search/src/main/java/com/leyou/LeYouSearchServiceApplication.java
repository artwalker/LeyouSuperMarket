package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author HackerStar
 * @create 2020-06-20 10:11
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LeYouSearchServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeYouSearchServiceApplication.class);
    }
}
