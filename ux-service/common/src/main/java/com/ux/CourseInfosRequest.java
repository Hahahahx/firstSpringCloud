package com.ux;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 课程信息请求对象定义
 * @Author: ux
 * @CreateDate: 2020/6/7 11:10
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfosRequest {
    private List<Long> ids;
}
