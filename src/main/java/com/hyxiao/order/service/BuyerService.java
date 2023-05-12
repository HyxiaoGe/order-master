package com.hyxiao.order.service;

import com.hyxiao.order.dto.OrderDTO;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-13 10:35
 **/
public interface BuyerService {

    /**
     * 查询一个订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO cancelOrder(String openid, String orderId);

}
