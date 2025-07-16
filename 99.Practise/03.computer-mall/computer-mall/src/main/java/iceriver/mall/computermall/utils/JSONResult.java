package iceriver.mall.computermall.utils;

import java.io.Serializable;

/**
 * 将响应头、响应体包装成类
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/9 19:40
 */
public class JSONResult<E> implements Serializable {
    private Integer state;
    private String message;
    private E data;

    public JSONResult() {
    }

    public JSONResult(Integer state) {
        this.state = state;
    }

    public JSONResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public JSONResult(Integer state, String message, E data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    /**
     * 这个构造方法没看懂，好像是状态码异常时捕获信息
     * @param e
     */
    public JSONResult(Throwable e) {
        this.message = e.getMessage();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}

