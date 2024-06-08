package com.javawebfinal.controller;

import com.javawebfinal.model.PageBean;
import com.javawebfinal.model.Result;
import com.javawebfinal.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    // 进入/product时直接跳转product.html
    @RequestMapping
    public String index(){
        return "product";
    }
    
    @ResponseBody
    @GetMapping("/getProduct")
    public Result page(Integer page, Integer size){
        log.info("ProductController.page(page {},size {})", page, size);
        PageBean pageBean = productService.page(page, size);
        return Result.success(pageBean);
    }
    
}