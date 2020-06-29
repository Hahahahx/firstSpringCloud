package com.ux.repository;

import com.ux.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: ux
 * @CreateDate: 2020/6/22 17:22
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 通过用户名查找用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);
}
