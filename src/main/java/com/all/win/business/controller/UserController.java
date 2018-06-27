package com.all.win.business.controller;

import com.all.win.business.pojo.User;
import com.all.win.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/add")
    public int insertUser(){
        User user = new User();
        user.setAge((byte)11);
        user.setName("诸葛流云");
        user.setGender((byte)0);
        user.setMobilePhone("13814932489");
        user.setAddress("苏州工业园区");
      return userService.insertUser(user);
    }

    @RequestMapping("/selectByUserId/{id}")
    @ResponseBody
    public User selectByUserId(@PathVariable Long id){
        return userService.selectUserById(id);
    }
}
