package service;

import com.ssx.bean.Order;
import com.ssx.bean.User;

import java.util.List;

public interface OrderService {
    //根据用户id查询用户地址
    User init(int userID);
    //根据用户id查询订单
    List<Order> getOrderListByUserID(int userID);
}
