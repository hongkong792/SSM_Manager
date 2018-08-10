package com.atguigu.crud.dao;

import com.atguigu.crud.bean.User;

import java.sql.SQLDataException;

public interface UserMapper {


     User selectById(int id);
     User selectByUser(User user) throws Exception;

}
