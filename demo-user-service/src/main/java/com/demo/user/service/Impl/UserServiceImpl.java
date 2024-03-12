package com.demo.user.service.Impl;

import com.demo.user.pojo.User;
import com.demo.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private static Map<Long, User> userMap = new HashMap<>();

    // 模拟数据
    static {
        userMap.put(1l, new User(1l, "张三"));
        userMap.put(2l, new User(2l, "李四"));
    }

    /**
     * 根据传入的 id 返回用户信息
     */
    public String queryUserInfo(Long id){
        return userMap.get(id).toString();
    }
}
