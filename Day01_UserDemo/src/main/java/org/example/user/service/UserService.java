package org.example.user.service;

import org.example.user.mapper.UserMapper;
import org.example.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author HackerStar
 * @create 2020-06-01 08:58
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void deleteById(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public List<User> queryAll() {
        return this.userMapper.selectAll();
    }
}
