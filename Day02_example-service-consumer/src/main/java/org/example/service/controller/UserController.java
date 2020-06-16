package org.example.service.controller;

import org.example.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author HackerStar
 * @create 2020-06-02 13:01
 */
@Controller
@RequestMapping("consumer/user")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient; // eureka客户端，可以获取到eureka中服务的信息

    @ResponseBody
    @GetMapping(produces = { "application/json;charset=UTF-8" })
    public User queryUserById(@RequestParam("id") Long id) {
        // 根据服务名称，获取服务实例。有可能是集群，所以是service实例集合
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        // 因为只有一个Service-provider。所以获取第一个实例
//        ServiceInstance instance = instances.get(0);
        // 获取ip和端口信息，拼接成服务地址
//        String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort()+ "/user/" + id;

        //直接通过服务名称调用
        String baseUrl = "http://service-provider/user/" + id;
        User user = this.restTemplate.getForObject(baseUrl, User.class);
        return user;
    }
}
