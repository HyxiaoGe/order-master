package com.hyxiao.order.enums;

import lombok.Getter;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-11 22:40
 **/
@Getter
public enum OrderStatusEnum implements CodeEnum {

    //
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
