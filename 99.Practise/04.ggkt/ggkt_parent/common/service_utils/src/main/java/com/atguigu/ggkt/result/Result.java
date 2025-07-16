package com.atguigu.ggkt.result;

import lombok.Data;

/**
 * 统一后端返回给前端的数据格式——json格式
 *
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/12 16:37
 */
@Data
public class Result<E> {
    private Integer code;
    private String message;
    private E data;

    public Result() {

    }

    /**
     * 成功，通过传参判断有无数据返回
     *
     * @param data
     * @param <E>
     * @return
     */
    public static <E> Result<E> ok(E data) {
        Result<E> result = new Result<>();
        result.setCode(20000);
        result.setMessage("成功");
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    /**
     * 失败，通过传参判断有无数据返回
     *
     * @param data
     * @param <E>
     * @return
     */
    public static <E> Result<E> fail(E data) {
        Result<E> result = new Result<>();
        result.setCode(20001);
        result.setMessage("失败");
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    /**
     * 修改ok()、fail()方法的message
     * @param msg
     * @return
     */
    public Result<E> message(String msg){
        this.setMessage(msg);
        return this;
    }

    /**
     * 修改ok()、fail()方法的code
     * @param code
     * @return
     */
    public Result<E> code(Integer code){
        this.setCode(code);
        return this;
    }
}
