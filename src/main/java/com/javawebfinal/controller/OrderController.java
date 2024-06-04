package com.javawebfinal.controller;

import com.javawebfinal.model.Result;
import com.javawebfinal.service.CartService;
import com.javawebfinal.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @RequestMapping
    public String index() {
        return "order";
    }

    @ResponseBody
    @RequestMapping("/addOrder")
    public Result addOrder(Integer uid) {
        log.info("OrderController.addOrder() " + uid);
        if (orderService.addOrder(uid)) {
            cartService.clearCart(uid); // 清空购物车
            return Result.success("订单已提交");
        } else {
            return Result.error("订单提交失败");
        }
    }
    
    @ResponseBody
    @RequestMapping("/getOrder")
    public Result getOrder(Integer uid) {
        log.info("OrderController.getOrder() " + uid);
        return Result.success(orderService.getOrder(uid));
    }
    
    @ResponseBody
    @RequestMapping("/pay")
    public Result pay(String oid) {
        log.info("OrderController.pay() " + oid);
        Double result = orderService.pay(oid);
        if (result >= 0) {
            String r = String.format("%.2f", result);
            return Result.success("支付成功，余额剩余：￥"+ r);
        } else if (result == -1) {
            return Result.error("余额不足");
        } else {
            return Result.error("支付失败");
        }
    }
    
    @ResponseBody
    @RequestMapping("/cancel")
    public Result cancel(String oid) {
        log.info("OrderController.cancel() " + oid);
        if (orderService.cancelOrder(oid)) {
            return Result.success("订单已取消");
        } else {
            return Result.error("取消失败");
        }
    }
    
    @ResponseBody
    @RequestMapping("/confirm")
    public Result confirm(String oid) {
        log.info("OrderController.confirm() " + oid);
        if (orderService.confirmOrder(oid)) {
            return Result.success("订单已确认收货");
        } else {
            return Result.error("操作失败");
        }
    }
}