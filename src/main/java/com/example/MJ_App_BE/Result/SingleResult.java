package com.example.MJ_App_BE.Result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleResult<T> extends CommonResult{
    private T data;
}
