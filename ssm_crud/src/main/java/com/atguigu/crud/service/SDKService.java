package com.atguigu.crud.service;

import com.atguigu.crud.bean.SDKModel;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.dao.SDKMapper;
import com.atguigu.crud.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SDKService {
    @Autowired
    SDKMapper dao;

    public List<SDKModel> selectSDKs() throws Exception
    {


        return dao.selectSDKs();

    }
}
