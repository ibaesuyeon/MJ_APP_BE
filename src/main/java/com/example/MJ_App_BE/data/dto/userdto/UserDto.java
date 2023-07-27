package com.example.MJ_App_BE.data.dto.userdto;

import lombok.*;

@Data
@NoArgsConstructor@AllArgsConstructor
@ToString@Builder
public class UserDto {
    private String deviceId;
    private int year;
    private Long userCampusId;
    private Long userCollegeId;
    private Long userMajorId;
    private Long userUnivId;
}
