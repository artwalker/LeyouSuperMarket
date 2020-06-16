package org.example.service.client;

import org.example.service.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author HackerStar
 * @create 2020-06-04 14:45
 */
@FeignClient(value = "service-provider", fallback = UserClientFallback.class) // 标注该类是一个feign接口
public interface UserClient {
    @GetMapping("user/{id}")
    User queryById(@PathVariable("id") Long id);
}
