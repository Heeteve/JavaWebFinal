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
     * @param size
     * @return
     */
    PageBean page(Integer page, Integer size);

    /**
     * 修改商品信息
     * @param product
     * @return Boolean
     */
    Boolean updateProduct(Product product);

    /**
     * 添加商品
     * @param product
     * @return
     */
    Boolean addProduct(Product product);

    /**
     * 删除商品
     * @param id
     * @return
     */
    Boolean deleteProduct(Integer id);
}