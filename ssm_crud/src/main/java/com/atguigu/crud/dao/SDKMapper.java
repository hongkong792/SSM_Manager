package com.atguigu.crud.dao;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import com.atguigu.crud.bean.SDKModel;

import java.util.List;

public interface SDKMapper {

    SDKModel selectByPrimaryKey(Integer empId);

    SDKModel selectByEmpName(String name);

    List<SDKModel> selectSDKs();
}
