package com.javawebfinal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
    private String order_id;
    private int user_id;
    private int product_id;
    private int quantity;
    private String brand;
    private String model;
    private double price;
    private String image;
    private int status; // 0：未支付，1：已支付，2：已收货
    private String order_time;
}