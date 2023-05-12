package com.hyxiao.order.enums;

import lombok.Getter;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-11 13:40
 **/
@Getter
public enum ProductStatusEnum implements CodeEnum{
    //  商品状态
    UP(0, "在架"),
    DOWN(1, "下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
