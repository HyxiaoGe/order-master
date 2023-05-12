package com.hyxiao.order.service;

import com.hyxiao.order.dataobject.SellerInfo;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-17 20:54
 **/
public interface SellerService {

    /**
     * 通过openID查询卖家端信息
     * @param openId
     * @return
     */
    SellerInfo findSellerInfoByOpenId(String openId);

}
