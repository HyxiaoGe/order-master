package com.hyxiao.order.dto;

import lombok.Data;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-12 11:19
 **/
@Data
public class CartDTO {

    /** 商品Id. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}

