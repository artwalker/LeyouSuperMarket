package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author HackerStar
 * @create 2020-06-11 09:20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LeyouUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeyouUploadApplication.class);
    }
}
