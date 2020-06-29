package com.ux.service;

import com.ux.UserInfo;
import com.ux.vo.CreateUserRequest;
import com.ux.vo.UserCourseInfo;

/**
 * 用户相关服务接口定义
 * @Author: ux
 * @CreateDate: 2020/6/24 8:42
 */
public interface UserService {
    /**
     * 创建用户
     * @param request
     * @return
     */
    UserInfo createUser(CreateUserRequest request);

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    UserInfo getUserInfo(Long id);

    /**
     * 获取用户和课程信息
     * @param id
     * @return
     */
    UserCourseInfo getUserCourseInfo(Long id);
}
