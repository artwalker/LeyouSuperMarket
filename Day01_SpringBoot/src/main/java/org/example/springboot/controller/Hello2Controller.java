package org.example.springboot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HackerStar
 * @create 2020-05-31 20:33
 */
@RestController
public class Hello2Controller {
    @GetMapping("show2")
    public String test() {
        return "Hello SpringBoot2~";
    }
}
