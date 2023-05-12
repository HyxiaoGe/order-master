package com.hyxiao.order.service.impl;

import com.hyxiao.order.dataobject.OrderDetail;
import com.hyxiao.order.dto.OrderDTO;
import com.hyxiao.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID  =  "123456";

    private final String ORDER_ID  =  "1605157892673626472";

    @Test
    public void create() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("小明");
        orderDTO.setBuyerAddress("深圳");
        orderDTO.setBuyerPhone("313513");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //  购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123458");
        orderDetail.setProductQuantity(1);
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("123457");
        orderDetail1.setProductQuantity(1);

        orderDetailList.add(orderDetail);
        orderDetailList.add(orderDetail1);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result={}", result);

    }

    @Test
    public void findOne() {
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】 result={}", result);
        Assert.assertEquals(ORDER_ID, result.getOrderId());
    }

    @Test
    public void findList() {

    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }

    @Test
    public void testFindList() {
    }
}