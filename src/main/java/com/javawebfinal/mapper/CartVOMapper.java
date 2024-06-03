package com.javawebfinal.mapper;

import com.javawebfinal.model.CartVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartVOMapper {
    // 查询所有购物车商品信息
    @Select("SELECT c.id, c.user_id, c.product_id, c.quantity, p.brand, p.model, p.price, p.image FROM fi_cart c JOIN fi_product p ON c.product_id = p.id WHERE user_id = #{user_id}")
    List<CartVO> listCartAllInfoByUId(int user_id);
}