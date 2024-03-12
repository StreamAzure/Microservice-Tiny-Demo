package com.demo.user.feign;

import com.demo.user.pojo.User;
import com.demo.user.service.UserService;
import com.stream.apis.user.IUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserClient implements IUserClient {

    @Autowired
    private UserService userService;
    @Override
    @GetMapping("/getUserInfo/{id}")
    public String queryUserInfo(@PathVariable("id") Long id) {
        System.out.println("userService被远程调用");
        return userService.queryUserInfo(id);
    }
}
