package com.hyxiao.order.service;

import com.hyxiao.order.dto.OrderDTO;

/**
 * 推送消息
 * @author: 潇歌
 * @create: 2020-11-19 00:49
 **/
public interface PushMessageService {

    /**
     *  订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);

}
