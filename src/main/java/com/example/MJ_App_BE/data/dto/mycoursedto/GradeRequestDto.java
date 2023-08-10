package com.example.MJ_App_BE.data.dto.mycoursedto;

import com.example.MJ_App_BE.data.entity.Grade;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GradeRequestDto {

    private Long myCourseId;
    private Grade grade;
}
