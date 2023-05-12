package com.hyxiao.order.service.impl;

import com.hyxiao.order.dataobject.SellerInfo;
import com.hyxiao.order.repository.SellerInfoRepository;
import com.hyxiao.order.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-17 20:55
 **/
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenId(String openId) {
        return repository.findByOpenid(openId);
    }
}
