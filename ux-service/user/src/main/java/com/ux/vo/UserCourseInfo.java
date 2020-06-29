package com.ux.vo;

import com.ux.CourseInfo;
import com.ux.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * 用户课程信息对象定义
 * @Author: ux
 * @CreateDate: 2020/6/22 17:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseInfo {

    private UserInfo userInfo;
    private List<CourseInfo> courseInfoList;

    /**
     * 返回一个无效的UserCourseInfo
     * @return
     */
    public static UserCourseInfo invalid(){
        return new UserCourseInfo(
                UserInfo.invaild(),
                Collections.emptyList()
        );
    }
}
