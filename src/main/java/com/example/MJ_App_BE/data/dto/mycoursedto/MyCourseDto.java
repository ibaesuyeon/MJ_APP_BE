package com.example.MJ_App_BE.data.dto.mycoursedto;

import com.example.MJ_App_BE.data.entity.Semester;
import lombok.*;

@Data
@NoArgsConstructor@AllArgsConstructor
@ToString@Builder
public class MyCourseDto {
    private int year;
    private Semester semester;
    private String grade;
    private String details;
    private Long myCourseCourseId;
    private Long myCourseUserId;
}
