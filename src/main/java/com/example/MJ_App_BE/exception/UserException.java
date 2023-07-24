package com.example.MJ_App_BE.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter@AllArgsConstructor
public class UserException extends RuntimeException{
    private final ErrorCode errorCode;
}
