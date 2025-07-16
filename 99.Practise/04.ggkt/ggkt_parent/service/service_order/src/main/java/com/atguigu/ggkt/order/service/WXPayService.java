package com.atguigu.ggkt.order.service;

import java.util.Map;

/**
 * @author zhuyuqi
 * @version v2.0
 * @interfaceName WXPayService
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/18 21:09
 */
public interface WXPayService {
    Map<String, Object> createJsapi(String orderNo);
}
