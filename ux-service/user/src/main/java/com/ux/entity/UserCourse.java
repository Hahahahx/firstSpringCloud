package com.ux.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * user_course表
 * @Author: ux
 * @CreateDate: 2020/6/22 17:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_course")
public class UserCourse {

    /**
     * 数据表主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 用户id
     */
    @Basic
    @Column(name = "user_id",nullable = false)
    private Long userId;

    /**
     * 课程id
     */
    @Basic
    @Column(name = "course_id",nullable = false)
    private Long courseId;

    /**
     * 创建时间
     */
    @Basic
    @CreatedDate
    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Basic
    @LastModifiedDate
    @Column(name = "update_time",nullable = false)
    private LocalDateTime updateTime;
}
