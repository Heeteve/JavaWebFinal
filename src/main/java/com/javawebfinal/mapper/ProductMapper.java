package com.javawebfinal.mapper;

import com.javawebfinal.model.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("SELECT * FROM fi_product")
    List<Product> listAllProducts();
    
    int addProduct(Product product);

    int updateProductById(Product product);

    int deleteProductById(@Param("id") int id);
}