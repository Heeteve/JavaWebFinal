package com.javawebfinal.service.impl;

import com.javawebfinal.mapper.OrderMapper;
import com.javawebfinal.mapper.UserMapper;
import com.javawebfinal.model.OrderVO;
import com.javawebfinal.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    
    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean addOrder(Integer user_id) {
        String order_id = String.valueOf(System.currentTimeMillis()); // order_id为当前时间戳
        return orderMapper.addOrderByUId(order_id, user_id);
    }

    @Override
    public List<OrderVO> getOrder(Integer user_id) {
        return orderMapper.listOrdersByUId(user_id);
    }

    @Override
    public Double pay(String order_id) {
        // 检查余额
        int uid = orderMapper.getUidByOid(order_id);
        double balance = userMapper.getBalanceByUid(uid);
        List<OrderVO> orderList = orderMapper.listOrdersByUId(uid);
        for (OrderVO order : orderList) {
            balance -= order.getPrice() * order.getQuantity();
        }
        if (balance < 0) {
            return -1.0; // 余额不足
        } else {
            orderMapper.updateOrderStatus(order_id, 1);
            userMapper.updateBalance(uid, balance);
            return balance; // 支付成功
        }
    }
    
    @Override
    public Boolean deliverOrder(String order_id) {
        return orderMapper.updateOrderStatus(order_id, 2);
    }
    
    @Override
    public Boolean confirmOrder(String order_id) {
        return orderMapper.updateOrderStatus(order_id, 3);
    }
    
    @Override
    public Boolean cancelOrder(String order_id) {
        return orderMapper.updateOrderStatus(order_id, 4);
    }

    @Override
    public Boolean deleteOrder(String order_id) {
        return orderMapper.deleteOrderByOId(order_id);
    }
}