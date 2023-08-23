package com.example.MJ_App_BE.data.dto.majordto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MajorResponseDto {

    private Long majorId;
    private String majorName;
    private Long majorCollegeId;


    public MajorResponseDto(){}

}