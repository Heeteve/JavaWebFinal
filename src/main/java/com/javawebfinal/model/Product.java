package com.javawebfinal.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private int id;
    private String brand;
    private String model;
    private double price;
    private String image;
    private String detail;
}