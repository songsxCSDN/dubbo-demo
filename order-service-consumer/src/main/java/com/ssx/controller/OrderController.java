package com.ssx.controller;

import com.ssx.bean.User;
import com.ssx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class OrderController {
    @Autowired
    private OrderService OrderService;

    @GetMapping("/hello")
    @ResponseBody
    public User getAddress(@RequestParam(value = "userID") int userID){
        User user = OrderService.init(userID);
        System.out.println(user.toString());
        return user;
    }
}
