package org.example.service.service;

import org.example.service.mapper.UserMapper;
import org.example.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HackerStar
 * @create 2020-06-02 11:12
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        return this.userMapper.selectByPrimaryKey(id);
    }
}
