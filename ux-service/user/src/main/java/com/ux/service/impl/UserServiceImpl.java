package com.ux.service.impl;

import com.ux.CourseInfo;
import com.ux.CourseInfosRequest;
import com.ux.UserInfo;
import com.ux.client.CourseClient;
import com.ux.entity.User;
import com.ux.entity.UserCourse;
import com.ux.repository.UserCourseRepository;
import com.ux.repository.UserRepository;
import com.ux.service.UserService;
import com.ux.vo.CreateUserRequest;
import com.ux.vo.UserCourseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 用户相关服务实现
 * @Author: ux
 * @CreateDate: 2020/6/24 8:45
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    /**
     * 用户
     */
    @Resource
    private UserRepository userRepository;

    /**
     * 用户课程
     */
    @Resource
    private UserCourseRepository userCourseRepository;

    /**
     * 通过Feign对课程服务里的信息进行查询
     */
    @Resource
    private CourseClient courseClient;

   /*
   使用构造函数的注解方式
    @Autowired
    public UserServiceImpl(
            UserRepository userRepository,
            UserCourseRepository userCourseRepository,
            CourseClient courseClient
    ){
        this.userRepository = userRepository;
        this.userCourseRepository = userCourseRepository;
        this.courseClient = courseClient;
    }
    */

    /**
     * 创建用户
     * @param request
     * @return
     */
    @Override
    public UserInfo createUser(CreateUserRequest request) {

        if(!request.validate()){
            return UserInfo.invaild();
        }
        User oldUser = userRepository.findByUsername(request.getUsername());
        if(null != oldUser){
            return UserInfo.invaild();
        }

        User newUser = userRepository.save(
                new User(request.getUsername(),request.getEmail())
        );

        return new UserInfo(
                newUser.getId(),
                newUser.getUsername(),
                newUser.getEmail()
        );
    }

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    @Override
    public UserInfo getUserInfo(Long id) {

        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            return UserInfo.invaild();
        }
        User curUser = user.get();

        return new UserInfo(
                curUser.getId(),
                curUser.getUsername(),
                curUser.getEmail()
        );
    }

    /**
     * 获取用户课程信息
     * @param id
     * @return
     */
    @Override
    public UserCourseInfo getUserCourseInfo(Long id) {

        // 先获取用户信息
        Optional<User>  user = userRepository.findById(id);
        if (!user.isPresent()){
            return UserCourseInfo.invalid();
        }

        User newUser = user.get();
        UserInfo userInfo = new UserInfo(
                newUser.getId(),
                newUser.getUsername(),
                newUser.getEmail()
        );

        // 再获取用户的对应课程列表
        List<UserCourse> userCourseList = userCourseRepository.findAllByUserId(id);
        if(CollectionUtils.isEmpty(userCourseList)){
            return new UserCourseInfo(userInfo, Collections.emptyList());
        }

        // 最后使用用户的课程ids通过Feign调用course服务获取对应的课程信息
        List<CourseInfo> courseInfos = courseClient.getCourseInfos(
                new CourseInfosRequest(userCourseList.stream()
                        .map(UserCourse::getCourseId)
                        .collect(Collectors.toList()))
        );

        return new UserCourseInfo(userInfo,courseInfos);
    }
}
