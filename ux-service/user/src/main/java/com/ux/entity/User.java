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
 * user表
 *
 * @Author: ux
 * @CreateDate: 2020/6/22 17:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User {

    /**
     * 数据表主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 用户名
     */
    @Basic
    @Column(name = "username", nullable = false)
    private String username;

    /**
     * 用户邮箱
     */
    @Basic
    @Column(name = "email", nullable = false)
    private String email;

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

    public User(String username,String email){
        this.username = username;
        this.email = email;
    }

}
