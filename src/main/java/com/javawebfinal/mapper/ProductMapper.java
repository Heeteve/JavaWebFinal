package com.javawebfinal.mapper;

import com.javawebfinal.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("SELECT * FROM fi_product")
    List<Product> listAllProducts();

    @Insert("INSERT INTO fi_product (brand, model, price, detail) VALUES (#{brand}, #{model}, #{price}, #{detail})")
    Boolean addProduct(Product product);

    @Update("UPDATE fi_product SET brand = #{brand}, model = #{model}, price = #{price}, detail = #{detail} WHERE id = #{id}")
    Boolean updateProductById(Product product);

    @Delete("DELETE FROM fi_product WHERE id = #{id}")
    Boolean deleteProductById(@Param("id") int id);
}