package com.all.win.business.service;

import com.all.win.business.entity.User;

/**
 * @Description:
 * @Author: fakerCoder
 * @Date: 2018/7/5 11:44
 * @Version: 1.0.0
 */
public interface UserService {

    /**
     * @Description:
     * @Author: fakerCoder
     * @Date: 2018/7/5 11:39
     * @Param: user
     * @Return: int
     */
    int insertUser(User user);

    /**
     * @Description:
     * @Author: fakerCoder
     * @Date: 2018/7/5 11:39
     * @Param: id
     * @Param name
     * @Param sex
     * @Return: com.all.win.business.entity.User
     */
    User selectUserById(Long id);
}
