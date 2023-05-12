package com.hyxiao.order.utils;

import com.hyxiao.order.enums.CodeEnum;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-16 16:52
 **/
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each: enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }

}
