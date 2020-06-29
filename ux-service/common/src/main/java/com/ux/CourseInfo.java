package com.ux;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程信息基本对象
 * @Author: ux
 * @CreateDate: 2020/6/7 11:09
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfo {
    private Long id;
    private String courseName;
    private String courseType;
    private String courseIcon;
    private String courseIntro;

    public static CourseInfo invaild(){
        return new CourseInfo(-1L,"","","","");
    }
}

