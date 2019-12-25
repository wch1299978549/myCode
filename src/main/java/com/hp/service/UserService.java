package com.hp.service;

import com.hp.mapper.UserMapper;
import com.hp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User queryUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public List<User> queryAllUser() {
        return userMapper.selectAll();
    }

    @Transactional
    public boolean deleteUserById(Long userId) {
        return userMapper.deleteByPrimaryKey(userId)>0;
    }
}
