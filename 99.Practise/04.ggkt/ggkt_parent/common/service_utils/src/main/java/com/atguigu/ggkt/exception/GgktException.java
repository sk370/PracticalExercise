package com.atguigu.ggkt.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常类
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/12 18:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GgktException extends RuntimeException{
    private Integer code;
    private String msg;
}
