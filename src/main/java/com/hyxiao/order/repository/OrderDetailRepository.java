package com.hyxiao.order.repository;

import com.hyxiao.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-12 00:01
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);

}
