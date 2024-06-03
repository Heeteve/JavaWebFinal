package com.javawebfinal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartVO {
    private int id;
    private int user_id;
    private int product_id;
    private int quantity;
    private String brand;
    private String model;
    private double price;
    private String image; // 商品图路径
}