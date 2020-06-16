package org.example.service.client;

import org.example.service.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author HackerStar
 * @create 2020-06-04 15:05
 */
@Component
public class UserClientFallback  implements UserClient{
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setUsername("服务器繁忙，请稍后再试!");
        return user;
    }
}
