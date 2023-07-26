package com.example.MJ_App_BE.data.dto.userdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ChangeUserDto {
    private Long userId;
    private int year;

    private int userCampusId;

    private int userCollegeId;

    private int userMajorId;

    private int userUnivId;



    public ChangeUserDto(Long userId, int year, int userCampusId, int userCollegeId, int userMajorId, int userUnivId){
        this.userId = userId;
        this.year = year;
        this.userCampusId = userCampusId;
        this.userCollegeId = userCollegeId;
        this.userMajorId = userMajorId;
        this.userUnivId = userUnivId;

    }

}