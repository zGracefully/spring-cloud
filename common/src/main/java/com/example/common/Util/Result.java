package com.example.common.Util;

import lombok.Data;

@Data
public class Result {
    private Integer code;
    private String message;
    private Object data;
    public Result(){}
    public Result(Object data){
        this.code = 200;
        this.message = "操作成功";
        this.data = data;
    }
    public Result(Integer code,String msg,Object data){
        this.code = code;
        this.message = msg;
        this.data = data;
    }
}
