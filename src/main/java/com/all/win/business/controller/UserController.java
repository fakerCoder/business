package com.all.win.business.controller;

import com.all.win.business.entity.User;
import com.all.win.business.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description:
 * @Author: fakerCoder
 * @Date: 2018/7/5 11:47
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("/user")
@Api("账号API接口")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("新增账号")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public int insertUser(){
        User user = new User();
        user.setAge((byte)11);
        user.setName("诸葛流云");
        user.setGender((byte)0);
        user.setMobilePhone("13814932489");
        user.setAddress("苏州工业园区");
        return userService.insertUser(user);
    }

    /**
     * @Description:
     * @Author: fakerCoder 
     * @Date: 2018/7/5 13:55
     * @Param: id
     * @Return: com.all.win.business.entity.User
     */
    @ApiOperation("查询单个账号信息")
    @RequestMapping(value = "/selectByUserId/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User selectByUserId(@ApiParam(value = "账号ID") @PathVariable Long id)
    {
        return userService.selectUserById(id);
    }
    @GetMapping(value = "/test")
    public String testAOP() {
        System.out.println("test");
        return "test";
    }

}
