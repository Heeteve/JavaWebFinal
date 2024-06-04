package com.javawebfinal.service;

import com.javawebfinal.model.OrderVO;

import java.util.List;

public interface OrderService {
    /**
     * 添加订单（直接获取该用户购物车所有商品）
     * @param user_id 用户id
     * @return Boolean
     */
    Boolean addOrder(Integer user_id);

    /**
     * 获取所有订单
     * @param user_id
     * @return List<OrderVO>
     */
    List<OrderVO> getOrder(Integer user_id);

    /**
     * 支付订单
     *
     * @param order_id
     * @return Boolean
     */
    Double pay(String order_id);
    
    /**
     * 取消订单
     * @param order_id
     * @return Boolean
     */
    Boolean cancelOrder(String order_id);
    
    /**
     * 确认收货
     * @param order_id
     * @return Boolean
     */
    Boolean confirmOrder(String order_id);
}