package com.leyou.auth.Service;

import com.leyou.auth.client.UserClient;
import com.leyou.auth.config.JwtProperties;
import com.leyou.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.UserInfo;
import utils.JwtUtils;

/**
 * @author HackerStar
 * @create 2020-07-03 09:52
 */
@Service
public class AuthService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private JwtProperties properties;

    public String authentication(String username, String password) {

        // 调用微服务，执行查询
        User user = this.userClient.queryUser(username, password);

        // 如果查询结果为null，则直接返回null
        if (user == null) {
            return null;
        }

        // 如果有查询结果，则生成token
        String token = null;
        try {
            token = JwtUtils.generateToken(new UserInfo(user.getId(), user.getUsername()),
                    properties.getPrivateKey(), properties.getExpire());
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }
}
