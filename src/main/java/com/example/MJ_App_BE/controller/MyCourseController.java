package com.example.MJ_App_BE.controller;

import com.example.MJ_App_BE.Result.CommonResult;
import com.example.MJ_App_BE.Result.ResponseService;
import com.example.MJ_App_BE.data.dto.mycoursedto.GradeRequestDto;
import com.example.MJ_App_BE.data.entity.Semester;
import com.example.MJ_App_BE.service.MyCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/myCourse")
@CrossOrigin(origins = "*")

public class MyCourseController {

    private final MyCourseService myCourseService;
    private final ResponseService responseService;

    @Autowired
    public MyCourseController(MyCourseService myCourseService, ResponseService responseService) {
        this.myCourseService = myCourseService;
        this.responseService = responseService;
    }

    //시간표 추가
    @PostMapping(value = "/myCourse/register")
    public CommonResult createUser(@RequestBody MyCourseDto myCourseDto) {
        myCourseService.saveCourse(myCourseDto);

        return responseService.getSuccessfulResult();
    }
    //시간표 수정

    @PutMapping("/grade")
    public CommonResult setGrade(@RequestBody GradeRequestDto gradeRequestDto) {
        myCourseService.setGradeMyCourse(gradeRequestDto);

        return responseService.getSuccessfulResult();
    }

    //시간표 확인
    @GetMapping("/grade/{userId}/all")
    public CommonResult getAllAverageGrade(@PathVariable Long userId) {
        double averageGrade = myCourseService.calculateAllAverageGrade(userId);
        CommonResult commonResult = responseService.getSingleResult(averageGrade);
        return commonResult;
    }

    @GetMapping("/grade/{userId}/{year}/{semester}")
    public CommonResult getAverageGradeForSpecificYearAndSemester(
            @PathVariable Long userId,
            @PathVariable int year,
            @PathVariable Semester semester) {
        double averageGrade = myCourseService.calculateAverageGradeYearAndSemester(userId, year, semester);
        CommonResult commonResult = responseService.getSingleResult(averageGrade);
        return commonResult;
    }

//    @GetMapping(value = "/myCourse/get/{userid}")
//    public CommonResult getMyCourse(@PathVariable Long userid) {
//        List<MyCourseResponseDto>  myCourseList = myCourseService.getMyCourse(userid);
//        CommonResult commonResult = responseService.getListResult(myCourseList);
//        return commonResult;
//    }
    //시간표 삭제
    @DeleteMapping(value = "/myCourse/deletion/{id}")
    public CommonResult deleteUser(@PathVariable Long id) throws Exception{
        myCourseService.deleteMyCourse(id);
        return responseService.getSuccessfulResult();
    }


}
