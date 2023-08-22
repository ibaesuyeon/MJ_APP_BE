package com.example.MJ_App_BE.service;


import com.example.MJ_App_BE.data.dto.mycoursedto.MyCourseDto;
import com.example.MJ_App_BE.data.dto.mycoursedto.MyCourseResponseDto;
import com.example.MJ_App_BE.data.dto.mycoursedto.GradeRequestDto;
import com.example.MJ_App_BE.data.entity.Grade;
import com.example.MJ_App_BE.data.entity.Semester;


import java.util.List;

public interface MyCourseService {

    void setGradeMyCourse(GradeRequestDto gradeRequestDto);

    double calculateAllAverageGrade(Long userId);
    double calculateAverageGradeYearAndSemester(Long userId, int year, Semester semester);

    MyCourseResponseDto saveCourse(MyCourseDto myCourseDto);

//    List<MyCourseResponseDto> getMyCourse(Long myCourseUserId);

    void deleteMyCourse(Long myCourseId) throws Exception;

    List<MyCourseResponseDto> getSemesterCourse(Long userId, int year, Semester semester);
}
