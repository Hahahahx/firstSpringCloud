package com.ux;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息基本对象
 * @Author: ux
 * @CreateDate: 2020/6/7 11:08
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private  Long id;
    private String username;
    private String email;

    public static UserInfo invaild(){
        return new UserInfo(-1L,"","");
    }
}
