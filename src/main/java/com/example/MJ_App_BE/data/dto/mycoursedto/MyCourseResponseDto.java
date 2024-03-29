package com.example.MJ_App_BE.data.dto.mycoursedto;

import com.example.MJ_App_BE.data.entity.Ctype;
import com.example.MJ_App_BE.data.entity.Grade;
import com.example.MJ_App_BE.data.entity.Semester;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MyCourseResponseDto {

    private Long myCourseId;
    private int year;
    private Semester semester;
    private Grade grade;
    private String cname;
    private int credit;
    private Ctype ctype;
    private Long myCourseUserId;

    public MyCourseResponseDto(){}

}