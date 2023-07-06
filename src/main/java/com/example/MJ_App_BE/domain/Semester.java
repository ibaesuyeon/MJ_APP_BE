package com.example.MJ_App_BE.domain;

import lombok.Getter;

@Getter
public enum Semester {

    SPRING("1학기"),
    SUMMER("하계 계절학기"),
    AUTUMN("2학기"),
    WINTER("동계 계절학기");

    private final String sName;
    Semester(String sName) { this.sName = sName; }
}
