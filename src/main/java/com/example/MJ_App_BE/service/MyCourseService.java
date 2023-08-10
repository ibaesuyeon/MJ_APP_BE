package com.example.MJ_App_BE.service;

import com.example.MJ_App_BE.data.dto.mycoursedto.GradeRequestDto;
import com.example.MJ_App_BE.data.entity.Grade;
import com.example.MJ_App_BE.data.entity.Semester;

public interface MyCourseService {

    void setGradeMyCourse(GradeRequestDto gradeRequestDto);

    double calculateAllAverageGrade(Long userId);
    double calculateAverageGradeYearAndSemester(Long userId, int year, Semester semester);
}
