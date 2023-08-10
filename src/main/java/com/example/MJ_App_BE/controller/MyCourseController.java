package com.example.MJ_App_BE.controller;

import com.example.MJ_App_BE.Result.CommonResult;
import com.example.MJ_App_BE.Result.ResponseService;
import com.example.MJ_App_BE.data.dto.mycoursedto.GradeRequestDto;
import com.example.MJ_App_BE.data.entity.Grade;
import com.example.MJ_App_BE.service.MyCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/my-course")
@CrossOrigin(origins = "*")

public class MyCourseController {

    private final MyCourseService myCourseService;
    private final ResponseService responseService;

    @Autowired
    public MyCourseController(MyCourseService myCourseService, ResponseService responseService) {
        this.myCourseService = myCourseService;
        this.responseService = responseService;
    }

    @PutMapping("/grade")
    public CommonResult setGrade(@RequestBody GradeRequestDto gradeRequestDto) {
        myCourseService.setGradeMyCourse(gradeRequestDto);

        return responseService.getSuccessfulResult();
    }

    // 수정 - setGrade랑 동일한 로직
    // 초기화 필요한지?

    @GetMapping("/grade/{userId}/all")
    public CommonResult getAllAverageGrade(@PathVariable Long userId) {
        double averageGrade = myCourseService.calculateAllAverageGrade(userId);
        CommonResult commonResult = responseService.getSingleResult(averageGrade);
        return commonResult;
    }

    // 고려할 점
    // 1. null값인 경우 - 제외?

}
