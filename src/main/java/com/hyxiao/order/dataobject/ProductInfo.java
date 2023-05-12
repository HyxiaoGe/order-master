package com.hyxiao.order.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hyxiao.order.enums.ProductStatusEnum;
import com.hyxiao.order.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-11 13:22
 **/
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    private static final long serialVersionUID = 6399186181668983148L;

    @Id
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /** 类目编号. */
    private Integer categoryType;

    public Date createTime;

    public Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
         return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }

}
