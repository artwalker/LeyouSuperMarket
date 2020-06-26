package com.leyou.demo.thymeleafdemo.controller;

import com.leyou.demo.thymeleafdemo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

/**
 * @author HackerStar
 * @create 2020-06-25 10:24
 */
@Controller
public class HelloController {
    @GetMapping("show1")
    public String show1(Model model) {
        model.addAttribute("msg", "Hello,Thymeleaf!");
        return "hello";
    }
    @GetMapping("show2")
    public String show2(Model model) {
        User user = new User();
        user.setAge(21);
        user.setName("Jack Chen");
        user.setFriend(new User("李小龙", 30));

        model.addAttribute("user",user);
        return "show2";
    }
    @GetMapping("show3")
    public String show3(Model model) {
        model.addAttribute("today", new Date());
        return "show3";
    }
}
