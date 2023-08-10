package com.example.MJ_App_BE.service;

import com.example.MJ_App_BE.data.dto.mycoursedto.GradeRequestDto;
import com.example.MJ_App_BE.data.entity.Grade;

public interface MyCourseService {

    void setGradeMyCourse(GradeRequestDto gradeRequestDto);

    double calculateAllAverageGrade(Long userId);
}
