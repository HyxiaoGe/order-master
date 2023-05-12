package com.hyxiao.order.repository;

import com.hyxiao.order.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-17 20:45
 **/
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);

}
