package com.javawebfinal.service;

import com.javawebfinal.model.PageBean;
import com.javawebfinal.model.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有商品
     * @return List
     */
    List<Product> listAllProducts();

    /**
     * 分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer size);
}