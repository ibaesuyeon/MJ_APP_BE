package com.example.MJ_App_BE.data.dto.userdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UserResponseDto {
    private int userId;
    private String deviceId;
    private int year;
    private int userCampusId;
    private int userCollegeId;
    private int userMajorId;
    private int userUnivId;


    public UserResponseDto(){}

}