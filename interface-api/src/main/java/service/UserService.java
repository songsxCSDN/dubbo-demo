package service;

import com.ssx.bean.Order;
import com.ssx.bean.User;

import java.util.List;

public interface UserService {
    //根据用户id查询用户地址
    User getUserAddress(int userID);
    //根据用户id查询用户订单
    List<Order> getOrder(int userID);
}
