package com.javawebfinal.mapper;

import com.javawebfinal.model.Order;
import com.javawebfinal.model.OrderVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    // 查询订单列表
    @Select("SELECT * FROM fi_order WHERE order_id = #{order_id}")
    List<Order> listOrder(String order_id);
    
    // 查询订单信息列表
    @Select("SELECT o.order_id, o.user_id, o.product_id, o.quantity, p.brand, p.model, p.price, p.image, o.status, o.order_time FROM fi_order o JOIN fi_product p ON o.product_id = p.id WHERE user_id = #{user_id}")
    List<OrderVO> listOrdersByUId(int user_id);
    
    // 通过uid查找购物车，加入订单
    @Insert("INSERT INTO fi_order (order_id, user_id, product_id, quantity) SELECT #{order_id}, #{user_id}, product_id, quantity FROM fi_cart WHERE user_id = #{user_id}")
    @Options(useGeneratedKeys = true, keyProperty = "id, status, order_time")
    Boolean addOrderByUId(String order_id, int user_id);
    
    // 更新订单状态
    @Update("UPDATE fi_order SET status = #{status} WHERE order_id = #{order_id}")
    Boolean updateOrderStatus(String order_id, int status);
    
    // 删除订单
    @Delete("DELETE FROM fi_order WHERE order_id = #{order_id}")
    Boolean deleteOrderByOId(String order_id);
    
    // 通过oid查询uid
    @Select("SELECT user_id FROM fi_order WHERE order_id = #{order_id} LIMIT 1")
    int getUidByOid(String order_id);
}