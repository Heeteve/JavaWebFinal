package com.javawebfinal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private String order_id;
    private int user_id;
    private int product_id;
    private int quantity;
    private int status; // 0：未支付，1：已支付，2：已发货，3：已收货，4：已取消
    private LocalDateTime order_time;
}