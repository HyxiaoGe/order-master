package com.hyxiao.order.exception;

import com.hyxiao.order.enums.ResultEnum;
import lombok.Getter;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-12 10:21
 **/
@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
