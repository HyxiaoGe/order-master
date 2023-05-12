package com.hyxiao.order.service;

import com.hyxiao.order.dataobject.ProductInfo;
import com.hyxiao.order.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-11 13:36
 **/
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //  加库存
    void increaseStock(List<CartDTO> cartDTOList);
    //  减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    public ProductInfo onSale(String productId);

    public ProductInfo offSale(String productId);

}
