package com.demo.user.controller;

import com.demo.user.pojo.User;
import com.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 用户查询接口
     */
    @GetMapping("/getUserInfo/{id}")
    public User queryUserInfo(@PathVariable("id") Long id){
        return userService.queryUserInfo(id);
    }

}
