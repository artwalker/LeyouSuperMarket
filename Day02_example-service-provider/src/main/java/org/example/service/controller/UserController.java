package org.example.service.controller;

import org.example.service.pojo.User;
import org.example.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HackerStar
 * @create 2020-06-02 11:11
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "{id}", produces = { "application/json;charset=UTF-8" })
    public User queryById(@PathVariable("id") Long id) {
        return this.userService.queryById(id);
    }
}
