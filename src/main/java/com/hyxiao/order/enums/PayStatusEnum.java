package com.hyxiao.order.enums;

import lombok.Getter;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-11 22:41
 **/
@Getter
public enum PayStatusEnum implements CodeEnum {

    //
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
