package com.example.MJ_App_BE.data.dto.userdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UserResponseDto {
    private Long userId;
    private String deviceId;
    private int year;
    private Long userCampusId;
    private Long userCollegeId;
    private Long userMajorId;
    private Long userUnivId;


    public UserResponseDto(){}

}