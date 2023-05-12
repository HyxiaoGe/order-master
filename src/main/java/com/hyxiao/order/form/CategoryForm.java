package com.hyxiao.order.form;

import lombok.Data;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-17 11:36
 **/
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

}
