package com.hyxiao.order.utils;

import javax.sound.midi.Soundbank;
import java.util.Random;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-12 10:38
 **/
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式： 时间 + 随机数
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);

    }

    public static void main(String[] args) {
        System.out.println(genUniqueKey());
    }

}
