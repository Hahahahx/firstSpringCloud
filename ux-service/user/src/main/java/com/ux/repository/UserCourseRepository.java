package com.ux.repository;

import com.ux.entity.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: ux
 * @CreateDate: 2020/6/22 17:23
 */
public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {
    /**
     * 通过用户id查找用户课程信息
     * @param userId
     * @return
     */
    List<UserCourse> findAllByUserId(Long userId);
}
