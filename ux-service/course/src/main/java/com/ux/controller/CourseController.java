package com.ux.controller;

import com.alibaba.fastjson.JSON;
import com.ux.CourseInfo;
import com.ux.CourseInfosRequest;
import com.ux.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程对外服务接口
 * @Author: ux
 * @CreateDate: 2020/6/10 11:08
 */

@Slf4j
@RestController
public class CourseController {

    @Resource
    private CourseService service;


    /**
     * 获取课程
     *
     * 如果不通过网关访问则，127.0.0.1:7001/ux-course/get/course?id=
     * (应该用)网关访问方式, 127.0.0.1:9000/xh/ux-course/get/course?id=
     * @param id
     * @return
     */
    @GetMapping("/get/course")
    public CourseInfo getCourseInfo(Long id){
        log.info("/ux-course:get course -> {}",id);
        return service.getCourseInfo(id);
    }
    @PostMapping("/get/courses")
    public List<CourseInfo> getCourseInfos(
            @RequestBody CourseInfosRequest request
            ){
        log.info("/ux-course:get courses -> {}", JSON.toJSONString(request));
        return service.getCourseInfos(request);
    }
}
