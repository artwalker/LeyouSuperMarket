package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author HackerStar
 * @create 2020-06-05 21:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LeyouItemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeyouItemServiceApplication.class);
    }
}
