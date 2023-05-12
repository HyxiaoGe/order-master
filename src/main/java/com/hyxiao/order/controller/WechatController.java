package com.hyxiao.order.controller;

import com.hyxiao.order.config.ProjectUrlConfig;
import com.hyxiao.order.enums.ResultEnum;
import com.hyxiao.order.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;

/**
 * @program: order
 * @author: 潇歌
 * @create: 2020-11-14 09:23
 **/
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxMpService wxOpenService;

    @Autowired
    private ProjectUrlConfig config;

    @GetMapping("/authorize")
    public String Authorize(@RequestParam("returnUrl") String returnUrl) {
        // 调用方法
        String url = "http://sell.springboot.cn/sell/wechat/userInfo";
        log.info("【微信网页授权】url={}", url);

        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_BASE, URLEncoder.encode(returnUrl));
        log.info("【微信网页授权】redirectUrl={}", redirectUrl);

        return "redirect:" + redirectUrl;

    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }

        String openId = wxMpOAuth2AccessToken.getOpenId();

        //这里要特别注意,url里的参数必须写openid,不能写成openId,因为前端代码是获取openid的值
        return "redirect:" + returnUrl + "?openid=" + openId;
    }

    @GetMapping("/qrAuthorize")
    public String qrAuthorize(@RequestParam("returnUrl") String returnUrl) {
        String url = "http://sell.springboot.cn/sell/wechat/qrUserInfo";
        String redirectUrl = wxOpenService.buildQrConnectUrl(url, WxConsts.QRCONNECT_SCOPE_SNSAPI_LOGIN, URLEncoder.encode(returnUrl));

        return "redirect:" + redirectUrl;

    }

    @GetMapping("/qrUserInfo")
    public String qrUserInfo(@RequestParam("code") String code){

        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxOpenService.oauth2getAccessToken(code);
        }catch (WxErrorException e){
            log.error("【微信网页授权】", e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        //  http://hyxiao.natapp1.cc/sell/wechat/qrUserInfo?code=091i9IFa1RmlZz0T3HHa1LqOaC4i9IF1
        log.error("wxMpOAuth2AccessToken={}", wxMpOAuth2AccessToken);
        String openId = wxMpOAuth2AccessToken.getOpenId();
        log.info("openId={}", openId);
        return "redirect:" + "?openid=" + openId;
    }


}
