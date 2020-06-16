package org.example.service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.example.service.client.UserClient;
import org.example.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author HackerStar
 * @create 2020-06-02 13:01
 */
@Controller
@RequestMapping("consumer/user")
@DefaultProperties(defaultFallback = "fallBackMethod") // 指定一个类的全局熔断方法
public class UserController {
//     @Autowired
//    private RestTemplate restTemplate;
//
//    @ResponseBody
//    @GetMapping(produces = { "application/json;charset=UTF-8" })
////    @HystrixCommand(fallbackMethod = "queryUserByIdFallBack")
//    @HystrixCommand
//    public String queryUserById(@RequestParam("id") Long id) {
//        String baseUrl = "http://service-provider/user/" + id;
//        User user = this.restTemplate.getForObject(baseUrl, User.class);
//        return user.toString();
//    }
//
////    public String queryUserByIdFallBack(Long id) {
////        return "请求繁忙，请稍后再试!";
////    }
//
//    /**
//     * 熔断方法
//     * 返回值要和被熔断的方法的返回值一致
//     * 熔断方法不需要参数
//     * @return
//     */
//    public String fallBackMethod() {
//        return "请求繁忙，请稍后再试!";
//    }

    @Autowired
    private UserClient userClient;

    @GetMapping(produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public User queryUserById(@RequestParam("id") Long id) {
        User user = userClient.queryById(id);
        return user;
    }
}
