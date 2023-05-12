package com.hyxiao.order.repository;

import com.hyxiao.order.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-11 11:11
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
