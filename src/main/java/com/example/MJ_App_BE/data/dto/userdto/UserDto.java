package com.example.MJ_App_BE.data.dto.userdto;

import lombok.*;

@Data
@NoArgsConstructor@AllArgsConstructor
@ToString@Builder
public class UserDto {
    private String deviceId;
    private int year;
    private int userCampusId;
    private int userCollegeId;
    private int userMajorId;
    private int userUnivId;
}
