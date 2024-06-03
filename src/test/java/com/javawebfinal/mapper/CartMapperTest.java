package com.javawebfinal.mapper;

import com.javawebfinal.model.CartVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CartMapperTest {
    @Autowired
    private CartMapper cartMapper;
    
    @Test
    void listCartByUId() {
        List<CartVO> cartVOList = cartMapper.listCartByUId(1);
        for (CartVO cartVO : cartVOList) {
            System.out.println(cartVO);
        }
    }
    
    @Test
    void getQuantityById() {
        Integer quantity = cartMapper.getQuantityById(1, 2);
        System.out.println(quantity);
    }
    
    @Test
    void addProductToCartById() {
        Boolean result = cartMapper.addProductToCartById(1,2,3);
        System.out.println(result);
    }
    
    @Test
    void updateQuantityById() {
        Boolean result = cartMapper.updateQuantityById(1, 1, 9);
        System.out.println(result);
    }
    
    @Test
    void deleteCartByPId() {
        Boolean result = cartMapper.deleteCartByPId(1,1);
        System.out.println(result);
    }
    
    @Test
    void deleteCartByUId() {
        cartMapper.deleteCartByUId(2);
    }
}