package com.example.demo1.v1.service;

import com.example.demo1.v1.bean.User;
import com.example.demo1.v1.mapping.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 根据用户Id 查
     * @param userId
     * @return
     */
    public User selectUserById(String userId){
        return userMapper.selectUserById(userId);
    }

}
