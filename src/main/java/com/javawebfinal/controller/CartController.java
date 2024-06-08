package com.javawebfinal.controller;

import com.javawebfinal.model.CartVO;
import com.javawebfinal.model.Result;
import com.javawebfinal.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping
    public String index() {
        return "cart";
    }

    @ResponseBody
    @GetMapping("/getCart")
    public Result getCart(Integer uid) {
        log.info("CartController.getCart(uid {})", uid);
        List<CartVO> cartList = cartService.getCart(uid);
        return Result.success(cartList);
    }

    @ResponseBody
    @GetMapping("/addCart")
    public Result addCart(Integer uid, Integer pid) {
        log.info("CartController.addCart(uid {}, pid {})", uid, pid);
        if (cartService.addCart(uid, pid)) {
            return Result.success("增加成功");
        } else {
            return Result.error("增加失败");
        }
    }

    @ResponseBody
    @GetMapping("/reduceCart")
    public Result reduceCart(Integer uid, Integer pid) {
        log.info("CartController.reduceCart(uid {}, pid {})", uid, pid);
        if (cartService.reduceCart(uid, pid)) {
            return Result.success("减少成功");
        } else {
            return Result.error("减少失败");
        }
    }
    
    @ResponseBody
    @GetMapping("/clearCart")
    public Result deleteCart(Integer uid) {
        log.info("CartController.clearCart(uid {}) ", uid);
        if (cartService.clearCart(uid)) {
            return Result.success("删除成功");
        } else {
            return Result.error("删除失败");
        }
    }

}