package com.ymzs.elm.advice;

/**
 * 统一返回结果类
 */
public class R<T> {
    private Integer code; // code: 状态码
    private String msg; // msg: 接口调用的提示信息
    private T data; // data: 返回数据

    public R() {
    }

    public R(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // 成功返回结果
    public static <T> R<T> ok(T data) {
        R<T> result = new R<T>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setmsg(ResultCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    // 失败返回失败信息
    public static R<Object> fail(Integer code, String msg) {
        return new R<>(code, msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getmsg() {
        return msg;
    }

    public void setmsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}