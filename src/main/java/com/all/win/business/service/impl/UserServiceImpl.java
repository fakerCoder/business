package com.all.win.business.service.impl;

import com.all.win.business.dao.UserMapper;
import com.all.win.business.entity.User;
import com.all.win.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: fakerCoder
 * @Date: 2018/7/5 15:01
 * @Version: 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @Description:
     * @Author: fakerCoder
     * @Date: 2018/7/5 11:39
     * @Param: user
     * @Return: int
     */
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    /**
     * @Description:
     * @Author: fakerCoder
     * @Date: 2018/7/5 11:39
     * @Param: id
     * @Param name
     * @Param sex
     * @Return: com.all.win.business.entity.User
     */
    public User selectUserById(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
