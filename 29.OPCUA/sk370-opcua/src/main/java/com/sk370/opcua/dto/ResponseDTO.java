package com.sk370.opcua.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体（webapi接口的返回）
 *
 * @author sk370
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ResponseDTO<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final int SUCCESS = 0;

    private static final int FAIL = 1;

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String msg;

    @Getter
    @Setter
    private T data;

    public static <T> ResponseDTO<T> ok() {
        return restResult(null, SUCCESS, null);
    }

    public static <T> ResponseDTO<T> ok(T data) {
        return restResult(data, SUCCESS, null);
    }

    public static <T> ResponseDTO<T> ok(T data, String msg) {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> ResponseDTO<T> failed() {
        return restResult(null, FAIL, null);
    }

    public static <T> ResponseDTO<T> failed(String msg) {
        return restResult(null, FAIL, msg);
    }

    public static <T> ResponseDTO<T> failed(T data) {
        return restResult(data, FAIL, null);
    }

    public static <T> ResponseDTO<T> failed(T data, String msg) {
        return restResult(data, FAIL, msg);
    }

    private static <T> ResponseDTO<T> restResult(T data, int code, String msg) {
        ResponseDTO<T> apiResult = new ResponseDTO<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
