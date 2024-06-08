package com.javawebfinal.service;

import com.javawebfinal.model.CartVO;

import java.util.List;

public interface CartService {
    /**
     * 添加商品到购物车
     * @param userId
     * @param productId
     * @return Boolean
     */
    Boolean addCart(Integer userId, Integer productId);

    /**
     * 查询购物车
     * @param userId
     * @return List<Cart>
     */
    List<CartVO> getCart(Integer userId);
    
    /**
     * 删除购物车商品
     * @param userId
     * @param productId
     * @return Boolean
     */
    Boolean deleteCart(Integer userId, Integer productId);

    /**
     * 减少购物车商品数量
     * @param uid
     * @param pid
     * @return Boolean
     */
    Boolean reduceCart(Integer uid, Integer pid);

    /**
     * 清空用户购物车
     * @param uid
     * @return Boolean
     */
    Boolean clearCart(Integer uid);
}