package com.ssx.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ssx.bean.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ssx.service.OrderService;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class UserController {
    //web接口调用订单服务
    @Reference
    OrderService OrderService;
    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping(value = "/sayhello")
    @ResponseBody
    public List<Order> getOrder(@RequestParam(value = "userID") int userID){

        List<Order> list = null;
        //缓存穿透问题
        if(userID != 0 ){
            //先去缓存中查找
            list = (List<Order>)redisTemplate.opsForList().leftPop(String.valueOf(userID));
            if(list == null || list.size() < 0){
                list = OrderService.getOrderListByUserID(userID);
                //放入缓存中
                redisTemplate.opsForList().leftPush(String.valueOf(userID),list);
            }else{
                //防止缓存穿透
                redisTemplate.opsForValue().set(String.valueOf(userID),null,60*5, TimeUnit.SECONDS);
            }
        }
        return list;
    }
    @GetMapping(value = "/sayhellos")
    @ResponseBody
    public List<Order> getOrders(@RequestParam(value = "userID") int userID){

        List<Order> list=OrderService.getOrderListByUserID(userID);
        //存入缓存
        return list;
    }

    /*
    登录跳转
     */
    @GetMapping(value = "/login")
    public String login(){
        return "/login/index";
    }
}
