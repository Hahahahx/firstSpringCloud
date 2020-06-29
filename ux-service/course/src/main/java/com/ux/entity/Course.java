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
 * course映射实体表定义
 *
 * @Author: ux
 * @CreateDate: 2020/6/8 9:48
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)  //自动创建时间与更新时间
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 课程名称
     */
    @Basic
    @Column(name = "course_name", nullable = false)
    private String courseName;

    /**
     * 课程类型：0（免费），1（实战）
     */
    @Basic
    @Column(name = "course_type", nullable = false)
    private Integer courseType;

    /**
     * 课程图标
     */
    @Basic
    @Column(name = "course_icon", nullable = false)
    private String courseIcon;

    /**
     * 课程介绍
     */
    @Basic
    @Column(name = "course_intro", nullable = false)
    private String courseIntro;

    /**
     * 创建时间
     */
    @Basic
    @CreatedDate
    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Basic
    @LastModifiedDate
    @Column(name = "update_time",nullable = false)
    private LocalDateTime updateTime;

    public Course(
            String courseName,Integer courseType,String courseIcon,String courseIntro
    ){
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseIcon = courseIcon;
        this.courseIntro = courseIntro;
    }

    /**
     * 返回无效的课程
     */
    public static Course invaild(){
        Course invaild = new Course("",0,"","");
        invaild.setId(-1L);
        return invaild;
    }


}
