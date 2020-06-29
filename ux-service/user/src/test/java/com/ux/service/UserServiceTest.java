package com.ux.service;

import com.alibaba.fastjson.JSON;
import com.ux.Appliction;
import com.ux.entity.UserCourse;
import com.ux.repository.UserCourseRepository;
import com.ux.vo.CreateUserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Arrays;

/**
 * 用户服务测试用例
 *
 * @Author: ux
 * @CreateDate: 2020/6/24 11:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Appliction.class})
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Resource
    UserCourseRepository userCourseRepository;

    @Test
    //  @Transactional 回滚策略 测试用例执行完毕后回滚，数据不会插入。
    public void testCreateUser() {

        // {"email":"ux@qq.com","id":6,"username":"ux"}

        System.out.println(JSON.toJSONString(
                userService.createUser(new CreateUserRequest("ux2", "ux@qq.com"))
        ));
    }

    @Test
    public void getGetUserInfo() {
        System.out.println(JSON.toJSONString(
                userService.getUserInfo(8L)
        ));
    }

    @Test
    public void testCreateUsercCourse() {
        UserCourse userCourse = new UserCourse();
        userCourse.setUserId(7L);
        userCourse.setCourseId(6L);

        UserCourse userCourse2 = new UserCourse();
        userCourse2.setUserId(8L);
        userCourse2.setCourseId(7L);

        System.out.println(userCourseRepository.saveAll(
                Arrays.asList(userCourse, userCourse2)
        ).size());
    }

}
