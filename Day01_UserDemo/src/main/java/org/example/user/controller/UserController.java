package org.example.user.controller;

import org.example.user.pojo.User;
import org.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author HackerStar
 * @create 2020-05-31 21:44
 */
//@RestController
@RequestMapping("user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    @ResponseBody
    public User queryUserById(@PathVariable("id") Long id) {
        return this.userService.queryById(id);
    }

    @GetMapping("list")
    public String all(ModelMap model) {
        // 查询用户
        List<User> users = this.userService.queryAll();
        // 放入模型
        model.addAttribute("users", users);
        // 返回模板名称（就是classpath:/templates/目录下的html文件名）
        return "users";
    }

    @GetMapping("hello")
    public String test() {
        return "hello ssm";
    }
}
