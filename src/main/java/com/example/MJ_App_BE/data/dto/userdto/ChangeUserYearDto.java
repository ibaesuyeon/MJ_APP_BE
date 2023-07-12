package com.example.MJ_App_BE.data.dto.userdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ChangeUserYearDto {
    private int userId;
    private int year;


    public ChangeUserYearDto(int userId, int year){
        this.userId = userId;
        this.year = year;
    }

}