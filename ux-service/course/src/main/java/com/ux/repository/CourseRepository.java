package com.ux.repository;

import com.ux.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: ux
 * @CreateDate: 2020/6/8 16:44
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
}
