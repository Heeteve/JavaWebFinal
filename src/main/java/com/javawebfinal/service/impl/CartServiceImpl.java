package com.javawebfinal.service.impl;

import com.javawebfinal.mapper.CartMapper;
import com.javawebfinal.model.CartVO;
import com.javawebfinal.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public Boolean addCart(Integer userId, Integer productId) {
        Integer count = cartMapper.getQuantityById(userId, productId);
        // 查询商品数量
        if (count == null) {
            // 如果购物车中没有该商品，则添加
            return cartMapper.addProductToCartById(userId, productId, 1);
        } else if (count > 0) {
            // 如果购物车中有该商品，则数量+1
            return cartMapper.updateQuantityById(userId, productId, count + 1);
        } else {
            return false;
        }
    }

    @Override
    public List<CartVO> getCart(Integer userId) {
        return cartMapper.listCartByUId(userId);
    }

    @Override
    public Boolean deleteCart(Integer userId, Integer productId) {
        return cartMapper.deleteCartByPId(userId, productId);
    }

    @Override
    public Boolean reduceCart(Integer uid, Integer pid) {
        Integer count = cartMapper.getQuantityById(uid, pid);
        if (count == 1) {
            // 如果商品数量为1，则删除
            return cartMapper.deleteCartByPId(uid, pid);
        } else if (count > 1) {
            // 如果商品数量大于1，则数量-1
            return cartMapper.updateQuantityById(uid, pid, count - 1);
        } else {
            return false;
        }
    }

    @Override
    public Boolean clearCart(Integer uid) {
        return cartMapper.deleteCartByUId(uid);
    }
}