package com.hyxiao.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-17 20:43
 **/
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}

