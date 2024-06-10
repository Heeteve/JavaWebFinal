package com.javawebfinal.controller;

import com.javawebfinal.model.PageBean;
import com.javawebfinal.model.Product;
import com.javawebfinal.model.Result;
import com.javawebfinal.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping
    public String product() {
        return "product";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "product-admin";
    }

    @ResponseBody
    @GetMapping("/getProduct")
    public Result page(Integer page, Integer size) {
        log.info("ProductController.page(page {},size {})", page, size);
        PageBean pageBean = productService.page(page, size);
        return Result.success(pageBean);
    }

    @ResponseBody
    @RequestMapping("/search")
    public Result search(String keyword, Integer page, Integer size) {
        log.info("OrderController.search(text {})", keyword);
        PageBean pageBean = productService.search(keyword, page, size);
        return Result.success(pageBean);
    }

    @ResponseBody
    @GetMapping("/admin/getProduct")
    public Result GetProduct() {
        log.info("ProductController.adminGetProduct()");
        List<Product> productList = productService.listAllProducts();
        return Result.success(productList);
    }

    @ResponseBody
    @PostMapping("/admin/updateProduct")
    public Result UpdateProduct(@RequestBody Product product) {
        log.info("ProductController.UpdateProduct(product {})", product);
        if (productService.updateProduct(product)) {
            return Result.success("更新成功");
        } else {
            return Result.error("更新失败");
        }
    }

    @ResponseBody
    @PostMapping("/admin/addProduct")
    public Result AddProduct(@RequestBody Product product) {
        log.info("ProductController.AddProduct(product {})", product);
        if (productService.addProduct(product)) {
            return Result.success("添加成功");
        } else {
            return Result.error("添加失败");
        }
    }

    @ResponseBody
    @GetMapping("/admin/deleteProduct")
    public Result DeleteProduct(Integer id) {
        log.info("ProductController.DeleteProduct(pid {})", id);
        if (productService.deleteProduct(id)) {
            return Result.success("删除成功");
        } else {
            return Result.error("删除失败");
        }
    }
}