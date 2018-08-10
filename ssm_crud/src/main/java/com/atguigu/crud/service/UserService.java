package com.atguigu.crud.service;

import com.atguigu.crud.bean.User;

import com.atguigu.crud.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper dao;

    public User selectByUser(User user) throws Exception
    {

        System.out.println("service:selectUser:"+user);
       return dao.selectByUser(user);

    }

}
