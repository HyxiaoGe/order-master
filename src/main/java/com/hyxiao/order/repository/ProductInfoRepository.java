package com.hyxiao.order.repository;

import com.hyxiao.order.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-11 13:23
 **/
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

}
