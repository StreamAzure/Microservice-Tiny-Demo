package com.demo.user.mapper;

import com.demo.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper{
    User getUserById(Long id);
}
