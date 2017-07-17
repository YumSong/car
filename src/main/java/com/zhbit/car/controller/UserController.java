package com.zhbit.car.controller;

import com.alibaba.fastjson.JSON;
import com.zhbit.car.service.user.entity.User;
import com.zhbit.car.service.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2017/7/17.
 */
@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUserById(Integer id){
        User user=userService.getUserById(id);
        String userStr= JSON.toJSONString(user);
        return userStr;
    }
}
