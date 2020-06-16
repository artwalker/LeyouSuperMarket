package org.example.service.mapper;

import org.example.service.pojo.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author HackerStar
 * @create 2020-06-02 11:11
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
}
