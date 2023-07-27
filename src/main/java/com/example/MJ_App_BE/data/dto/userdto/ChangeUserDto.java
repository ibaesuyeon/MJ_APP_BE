package com.example.MJ_App_BE.data.dto.userdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ChangeUserDto {
    private Long userId;
    private int year;

    private Long userCampusId;

    private Long userCollegeId;

    private Long userMajorId;

    private Long userUnivId;



    public ChangeUserDto(Long userId, int year, Long userCampusId, Long userCollegeId, Long userMajorId, Long userUnivId){
        this.userId = userId;
        this.year = year;
        this.userCampusId = userCampusId;
        this.userCollegeId = userCollegeId;
        this.userMajorId = userMajorId;
        this.userUnivId = userUnivId;

    }

}