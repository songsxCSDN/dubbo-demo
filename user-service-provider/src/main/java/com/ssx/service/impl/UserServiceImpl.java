package com.ssx.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ssx.bean.Address;
import com.ssx.bean.Order;
import com.ssx.bean.User;
import com.ssx.service.OrderService;
import com.ssx.service.UserService;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    com.ssx.mapper.UserMapper UserMapper;
    @Resource
    com.ssx.mapper.AddressMapper AddressMapper;
    @Reference
    OrderService OrderService;
    @Override
    public User getUserAddress(int userID) {
        User user =  UserMapper.getAdressByUserID(userID);
        List<Address> addressList = AddressMapper.getAdressByID(userID);
        user.setAddress(addressList);
        return user;
    }

    @Override
    public List<Order> getOrder(int userID) {
        return OrderService.getOrderListByUserID(userID);
    }
}
