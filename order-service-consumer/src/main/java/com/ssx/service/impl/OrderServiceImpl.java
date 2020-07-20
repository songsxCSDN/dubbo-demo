package com.ssx.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ssx.bean.Order;
import com.ssx.bean.User;
import com.ssx.service.OrderService;
import com.ssx.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Reference
    UserService UserService;
    @Resource
    com.ssx.mapper.OrderMapper OrderMapper;
    @Override
    public User init(int userID) {
        //初始化订单。调用用户地址
        User Users =  UserService.getUserAddress(userID);
        return Users;
    }

    @Override
    public List<Order> getOrderListByUserID(int userID) {
        List<Order> list =  OrderMapper.getOrderByUserID(userID);
        return list;
    }

}
