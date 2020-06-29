package com.ux.service;

import com.alibaba.fastjson.JSON;
import com.ux.Application;
import com.ux.CourseInfosRequest;
import com.ux.entity.Course;
import com.ux.repository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 课程服务测试
 * @Author: ux
 * @CreateDate: 2020/6/10 11:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {Application.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE
)
public class CourseServiceTest {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;

    @Test
    public void testCreateCourseInfo(){
        Course course1 = new Course(
                "JDK11",0,"http://www.ux.com/","妹啥"
        );
        Course course2 = new Course(
                "JDK12",0,"http://www.ux.com/","啥"
        );
        System.out.println(courseRepository.saveAll(
                Arrays.asList(course1,course2)
        ).size());
    }

    @Test
    public void testGetCourseInfo(){
        System.out.println(JSON.toJSONString(
                courseService.getCourseInfo(6L)
        ));
        System.out.println(JSON.toJSONString(
                courseService.getCourseInfo(8L)
        ));
    }

    @Test
    public void testGetCourseInfos(){
        System.out.println(JSON.toJSONString(
                courseService.getCourseInfos(
                        new CourseInfosRequest(Arrays.asList(6L,8L))
                )
        ));
    }
}
