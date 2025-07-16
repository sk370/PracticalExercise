package com.atguigu.ggkt.order.service.impl;

import com.atguigu.ggkt.client.user.UserInfoFeignClient;
import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.order.service.OrderInfoService;
import com.atguigu.ggkt.order.service.WXPayService;
import com.atguigu.ggkt.utils.HttpClientUtils;
import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className WXPayServiceImpl
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/18 21:11
 */
@Service
public class WXPayServiceImpl implements WXPayService {
    @Autowired
    private OrderInfoService orderInfoService;
    @Resource
    private UserInfoFeignClient userInfoFeignClient;

    @Override
    public Map<String, Object> createJsapi(String orderNo) {
        try {

            Map<String, String> paramMap = new HashMap();
            //1、设置参数
            paramMap.put("appid", "wxf913bfa3a2c7eeeb");//商户id（正式服务号才有）
            paramMap.put("mch_id", "1481962542");//商户号（正式服务号才有）
            paramMap.put("nonce_str", WXPayUtil.generateNonceStr());//支付时的随机数
            paramMap.put("body", "test");//支付窗口显示内容
            paramMap.put("out_trade_no", orderNo);//订单号
            paramMap.put("total_fee", "1");//支付金额
            paramMap.put("spbill_create_ip", "127.0.0.1");//当前支付客户端ip
            paramMap.put("notify_url", "http://glkt.atguigu.cn/api/order/wxPay/notify");//支付成功后的跳转
            paramMap.put("trade_type", "JSAPI");//支付类型，按照生成的固定金额支付
            paramMap.put("openid", "oQTXC56lAy3xMOCkKCImHtHoLL");//当前用户的openId,正常情况：根据订单号获取userId，根据userId获取openId

            //2、HTTPClient来根据URL访问第三方接口并且传递参数
            HttpClientUtils client = new HttpClientUtils("https://api.mch.weixin.qq.com/pay/unifiedorder");
            //client设置参数
            client.setXmlParam(WXPayUtil.generateSignedXml(paramMap, "MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9"));//商户key（正式服务号才有）
            client.setHttps(true);
            client.post();

            //3、微信支付接口的返回数据
            String xml = client.getContent();
            Map<String, String> resultMap = WXPayUtil.xmlToMap(xml);
            if(null != resultMap.get("result_code")  && !"SUCCESS".equals(resultMap.get("result_code"))) {
                throw new GgktException(20001, "支付失败");
            }

            //4、从支付接口的返回数据中再次封装参数
            Map<String, String> parameterMap = new HashMap<>();
            String prepayId = String.valueOf(resultMap.get("prepay_id"));
            String packages = "prepay_id=" + prepayId;
            parameterMap.put("appId", "wxf913bfa3a2c7eeeb");
            parameterMap.put("nonceStr", resultMap.get("nonce_str"));
            parameterMap.put("package", packages);
            parameterMap.put("signType", "MD5");
            parameterMap.put("timeStamp", String.valueOf(new Date().getTime()));
            String sign = WXPayUtil.generateSignature(parameterMap, "MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9");

            //返回结果
            Map<String, Object> result = new HashMap();
            result.put("appId", "wxf913bfa3a2c7eeeb");
            result.put("timeStamp", parameterMap.get("timeStamp"));
            result.put("nonceStr", parameterMap.get("nonceStr"));
            result.put("signType", "MD5");
            result.put("paySign", sign);
            result.put("package", packages);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}
