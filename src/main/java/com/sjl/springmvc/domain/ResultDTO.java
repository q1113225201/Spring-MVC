package com.sjl.springmvc.domain;

import java.io.Serializable;

public class ResultDTO<T> implements Serializable {
    private int code;
    private T data;
    private String msg;

    public ResultDTO() {
    }

    public ResultDTO(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
