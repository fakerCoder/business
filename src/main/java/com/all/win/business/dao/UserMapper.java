package com.all.win.business.dao;

import com.all.win.business.pojo.User;


public interface UserMapper {
    int insertUser(User user);

    User selectByUserId(Long id);

    int updateUser(User user);
}
