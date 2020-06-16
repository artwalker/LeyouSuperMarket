package org.example.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.user.pojo.User;

/**
 * @author HackerStar
 * @create 2020-06-01 08:52
 */
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {
}
