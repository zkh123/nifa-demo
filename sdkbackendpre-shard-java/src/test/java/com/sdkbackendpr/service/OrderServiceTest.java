package com.sdkbackendpr.service;

import com.sdkbackendpr.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * Created by huanglijun on 2020/4/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceTest {

    @Resource
    OrderService orderService;

    public static Long orderId = 1L;
    public static Long userId = 1L;

    @Test
    public void insert() {
        for (int i = 1; i <= 10; i++) {
            Order order = new Order();
            order.setOrderId(i);
            order.setUserId(i);
            orderId++;
            userId++;
            orderService.insert(order);
        }
    }

    @Test
    public void getOrderInfoByOrderId() {
    }

}