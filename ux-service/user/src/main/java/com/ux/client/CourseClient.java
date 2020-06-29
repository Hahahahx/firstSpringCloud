package com.ux.client;

import com.ux.CourseInfo;
import com.ux.CourseInfosRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 通过Feign访问课程微服务
 * 可以结合Hystrix实现服务熔断，实现一些兜底策略，熔断降级
 * @Author: ux
 * @CreateDate: 2020/6/22 17:27
 */
@FeignClient(value = "eureka-client-ux-course",fallback = CourseClientHystrix.class) //当调用失败是就回到Hystrix的回滚策略中，实现熔断降级
public interface CourseClient {

    @RequestMapping(value = "/ux-course/get/course", method = RequestMethod.GET)
    CourseInfo getCourseInfo(Long id);

    @PostMapping("/ux-course/get/courses")
    List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request);


}
