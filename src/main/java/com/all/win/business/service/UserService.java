package com.all.win.business.service;


import com.all.win.business.dao.UserMapper;
import com.all.win.business.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
   private UserMapper userMapper;

    public int insertUser(User user){
        return userMapper.insertUser(user);
    }
    public User selectUserById(Long id){
        User user = userMapper.selectByUserId(id);
        return user;
    }
}
