package com.hyxiao.order.service;

import com.hyxiao.order.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-12 17:11
 **/
public interface PayService {

    public PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund (OrderDTO orderDTO);

}
