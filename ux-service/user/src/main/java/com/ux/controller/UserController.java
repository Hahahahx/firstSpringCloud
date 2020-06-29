package com.ux.controller;

import com.alibaba.fastjson.JSON;
import com.ux.UserInfo;
import com.ux.service.UserService;
import com.ux.vo.CreateUserRequest;
import com.ux.vo.UserCourseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户服务对外接口
 * @Author: ux
 * @CreateDate: 2020/6/24 11:20
 */
@Slf4j
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/create/user")
    public UserInfo createUser(@RequestBody CreateUserRequest request){
        log.info("<user>:create user -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }

    @GetMapping("/get/user")
    public UserInfo getUserInfo(Long id){
        log.info("<user>:get user -> {}", id);
        return userService.getUserInfo(id);
    }

    @GetMapping("/get/user/course")
    public UserCourseInfo getUserCourseInfo(Long id){
        log.info("<user>:get user course info -> {}", id);
        return userService.getUserCourseInfo(id);
    }


}
