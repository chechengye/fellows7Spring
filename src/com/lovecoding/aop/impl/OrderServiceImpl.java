package com.lovecoding.aop.impl;

import com.lovecoding.aop.OrderService;
import org.springframework.stereotype.Service;

/**
 * 注入到容器中
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void addOrder() {
        System.out.println("添加订单");
        int i = 1/0;
    }

    @Override
    public int updateOrderById(int id) {
        System.out.println("更新订单");
        return 0;
    }

    @Override
    public void deleteById(int id) {
        System.out.println("删除订单");
    }
}
