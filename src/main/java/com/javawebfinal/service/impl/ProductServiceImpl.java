package com.javawebfinal.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.javawebfinal.mapper.ProductMapper;
import com.javawebfinal.model.PageBean;
import com.javawebfinal.model.Product;
import com.javawebfinal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> listAllProducts() {
        return productMapper.listAllProducts();
    }

    @Override
    public PageBean page(Integer page, Integer size) {
        //1. 设置分页参数
        PageHelper.startPage(page, size);

        //2. 执行查询
        List<Product> productList = productMapper.listAllProducts();
        Page<Product> p = (Page<Product>) productList;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public Boolean updateProduct(Product product) {
        return productMapper.updateProductById(product);
    }

    @Override
    public Boolean addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    @Override
    public Boolean deleteProduct(Integer id) {
        return productMapper.deleteProductById(id);
    }
}