package com.zhbit.car.service.user.dao;

import com.zhbit.car.service.core.base.BaseDao;
import com.zhbit.car.service.user.entity.User;
import com.zhbit.car.service.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/7/17.
 */
@Component(value = "UserDao")
public class UserDao extends BaseDao<User,UserMapper,Integer> implements UserMapper {

    @Override
    public String getMapperNamesapce() {
        return UserMapper.class.getName().toString();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return  getMapperByType(UserMapper.class).deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return getMapperByType(UserMapper.class).insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return getMapperByType(UserMapper.class).insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return getMapperByType(UserMapper.class).selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return getMapperByType(UserMapper.class).updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return getMapperByType(UserMapper.class).updateByPrimaryKey(record);
    }
}
