package com.ux.service;


import com.ux.CourseInfo;
import com.ux.CourseInfosRequest;

import java.util.List;

/**
 * 课程相关服务接口定义
 * @Author: ux
 * @CreateDate: 2020/6/8 16:47
 */
public interface CourseService {

    /**
     * 通过id获取课程信息
     */
    CourseInfo getCourseInfo(Long id);

    /**
     * 通过id列表获取课程列表信息
     */
    List<CourseInfo> getCourseInfos(CourseInfosRequest request);
}
