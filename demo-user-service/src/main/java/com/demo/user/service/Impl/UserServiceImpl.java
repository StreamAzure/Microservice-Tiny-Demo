package com.demo.user.service.Impl;

import com.demo.user.mapper.UserMapper;
import com.demo.user.pojo.User;
import com.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    // Map 模拟数据
    private static Map<Long, User> userMap = new HashMap<>();
    static {
        userMap.put(3l, new User(3l, "张三"));
        userMap.put(4l, new User(4l, "李四"));
    }

    /**
     * 根据传入的 id 返回用户信息
     */
    public String queryUserInfo(Long id){
        User user = null;
        if (userMap.get(id) == null){
            // 如果在 Map 模拟数据中找不到，在数据库中找
            user = userMapper.getUserById(id);
        }
        else user = userMap.get(id);
        return user.toString();
    }
}
