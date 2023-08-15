package com.example.MJ_App_BE.service;


import com.example.MJ_App_BE.data.dto.mycoursedto.MyCourseDto;
import com.example.MJ_App_BE.data.dto.mycoursedto.MyCourseResponseDto;

import java.util.List;

public interface MyCourseService {


    MyCourseResponseDto saveCourse(MyCourseDto myCourseDto);

//    List<MyCourseResponseDto> getMyCourse(Long myCourseUserId);

    void deleteMyCourse(Long myCourseId) throws Exception;
}
