package com.stream.apis.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service", url = "localhost:8081")
public interface IUserClient {
    @GetMapping("/getUserInfo/{id}")
    String queryUserInfo(@PathVariable("id") Long id);
}
