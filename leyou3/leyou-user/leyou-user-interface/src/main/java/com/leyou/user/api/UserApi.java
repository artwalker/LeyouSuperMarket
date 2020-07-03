package com.leyou.user.api;

import com.leyou.user.pojo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author HackerStar
 * @create 2020-07-03 10:14
 */
public interface UserApi {
    @GetMapping("query")
    public User queryUser(@RequestParam("username") String username,
                          @RequestParam("password") String password);
}
