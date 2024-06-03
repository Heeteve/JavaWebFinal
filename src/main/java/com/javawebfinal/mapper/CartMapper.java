package com.javawebfinal.mapper;

import com.javawebfinal.model.CartVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartMapper {

    // 查询购物车ByUId
    @Select("SELECT c.id, c.user_id, c.product_id, c.quantity, p.brand, p.model, p.price, p.image FROM fi_cart c JOIN fi_product p ON c.product_id = p.id WHERE user_id = #{user_id}")
    List<CartVO> listCartByUId(int user_id);

    // 根据商品ID查询商品数量
    @Select("SELECT IFNULL(quantity, 0) AS quantity FROM fi_cart WHERE user_id = #{user_id} AND product_id = #{product_id} ")
    Integer getQuantityById(int user_id, int product_id);

    // 新添加商品
    @Insert("INSERT INTO fi_cart (user_id, product_id, quantity) VALUES (#{user_id}, #{product_id}, #{quantity})")
    Boolean addProductToCartById(int user_id, int product_id, int quantity);

    // 更新商品数量
    @Update("UPDATE fi_cart SET quantity = #{quantity} WHERE user_id = #{user_id} AND product_id = #{product_id}")
    Boolean updateQuantityById(int user_id, int product_id, int quantity);

    // 删除购物车中的商品
    @Delete("DELETE FROM fi_cart WHERE user_id = #{user_id} AND product_id = #{product_id}")
    Boolean deleteCartByPId(int user_id, int product_id);

    // 清空用户购物车
    @Delete("DELETE FROM fi_cart WHERE user_id = #{user_id}")
    Boolean deleteCartByUId(int user_id);
}