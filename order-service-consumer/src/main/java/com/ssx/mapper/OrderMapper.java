package com.ssx.mapper;

import com.ssx.bean.Order;

import java.util.List;

public interface OrderMapper {

    List<Order> getOrderByUserID(int userID);
}
