package com.hyxiao.order.service;

import com.hyxiao.order.dataobject.ProductCategory;

import java.util.List;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-11 11:57
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
