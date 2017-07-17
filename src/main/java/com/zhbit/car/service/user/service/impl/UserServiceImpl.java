package com.zhbit.car.service.user.service.impl;

import com.zhbit.car.service.user.entity.User;
import com.zhbit.car.service.user.mapper.UserMapper;
import com.zhbit.car.service.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/7/17.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
