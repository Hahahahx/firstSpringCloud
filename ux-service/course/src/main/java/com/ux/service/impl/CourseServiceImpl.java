package com.ux.service.impl;

import com.ux.CourseInfo;
import com.ux.CourseInfosRequest;
import com.ux.entity.Course;
import com.ux.repository.CourseRepository;
import com.ux.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 课程服务功能实现
 * @Author: ux
 * @CreateDate: 2020/6/9 15:14
 */
@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseRepository courseRepository;

    @Override
    public CourseInfo getCourseInfo(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return buildCourseInfo(course.orElse(Course.invaild()));
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        if(CollectionUtils.isEmpty(request.getIds())){
            return Collections.emptyList();
        }

        List<Course> courses = courseRepository.findAllById(request.getIds());
        //ids有可能无效，此处先不做这个判断
        return courses.stream()
                .map(this::buildCourseInfo)
                .collect(Collectors.toList());
    }

    /**
     * 根据数据记录构造对象信息
     * 实体对象到vo对象的转换
     * @param course
     * @return
     */
    private CourseInfo buildCourseInfo(Course course){
        return CourseInfo.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseType(
                        course.getCourseType() == 0 ? "免费课程": "实战课程"
                )
                .courseIcon(course.getCourseIcon())
                .courseIntro(course.getCourseIntro())
                .build();
    }
}
