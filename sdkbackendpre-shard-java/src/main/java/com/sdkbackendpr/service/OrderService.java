package com.sdkbackendpr.service;

import com.sdkbackendpr.entity.Order;
import com.sdkbackendpr.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class OrderService {
    @Resource
    OrderMapper orderMapper;


    public void insert(Order order) {
        orderMapper.insert(order);
    }

    public Order getOrderInfoByOrderId(Integer id){
        return orderMapper.selectByPrimaryKey(id);
    }

}
