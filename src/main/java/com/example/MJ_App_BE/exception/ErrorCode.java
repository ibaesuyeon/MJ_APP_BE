package com.example.MJ_App_BE.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(NOT_FOUND, "해당 기기정보를 찾을 수 없습니다."),
    COURSE_NOT_FOUND(NOT_FOUND, "해당 강좌정보를 찾을 수 없습니다."),
    DUPLICATE_RESOURCE(CONFLICT, "데이터가 이미 존재합니다.")
    ;

    private final HttpStatus httpStatus;
    private final String detail;
}
