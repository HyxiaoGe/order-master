package com.hyxiao.order.controller;

import com.hyxiao.order.dto.OrderDTO;
import com.hyxiao.order.enums.ResultEnum;
import com.hyxiao.order.exception.SellException;
import com.hyxiao.order.service.OrderService;
import com.hyxiao.order.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.Map;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-14 23:12
 **/
@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId, @RequestParam("returnUrl") String returnUrl, Map<String, Object> map){

        //  1、查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //  发起支付
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse", payResponse);

        map.put("returnUrl", URLDecoder.decode(returnUrl));

        return new ModelAndView("pay/create", map);

    }

    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData){
        payService.notify(notifyData);
        //  返回给微信处理结果
        return new ModelAndView("pay/success");

    }

}
