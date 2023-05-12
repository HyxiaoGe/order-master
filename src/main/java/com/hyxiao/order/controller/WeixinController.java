package com.hyxiao.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-13 17:10
 **/
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
      log.info("进入到auth方法。。。。。。。。。");
      log.info("code={}", code);

        /**

         https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx5443ac2bbafd0ff6&redirect_uri=hyxiao.natapp1.cc/sell/weixin/auth&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect

         */

      String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx5443ac2bbafd0ff6&secret=bfbdd8f342fe3e78a55c5548678ab222&code=" + code + "&grant_type=authorization_code";

      RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        log.info("response={}", response);

    }

}
