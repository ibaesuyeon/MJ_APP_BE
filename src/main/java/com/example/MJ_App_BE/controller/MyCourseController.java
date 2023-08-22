package com.example.MJ_App_BE.controller;

import com.example.MJ_App_BE.Result.CommonResult;
import com.example.MJ_App_BE.Result.ListResult;
import com.example.MJ_App_BE.Result.ResponseService;
import com.example.MJ_App_BE.data.dto.mycoursedto.GradeRequestDto;
import com.example.MJ_App_BE.data.dto.mycoursedto.MyCourseDto;
import com.example.MJ_App_BE.data.dto.mycoursedto.MyCourseResponseDto;
import com.example.MJ_App_BE.data.dto.noticedto.NoticeResponseDto;
import com.example.MJ_App_BE.data.entity.Semester;
import com.example.MJ_App_BE.service.MyCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //학기 수강강의 목록 불러오기
    @GetMapping("/myCourse/{userId}/{year}/{semester}")
    public CommonResult getSemesterCourse(
            @PathVariable Long userId,
            @PathVariable int year,
            @PathVariable Semester semester) {
        List<MyCourseResponseDto> mycourses = myCourseService.getSemesterCourse(userId,year,semester);
        ListResult listResult = responseService.getListResult(mycourses);
        return listResult;
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


    //강의별 성적 입력하기

    //강의 추가하기

    //사용자의 지금까지 들은 전체 학점 불러오기(공통교양 총 몇점, 핵심교양 총 몇학점 => 이런식으로)


    //시간표 삭제
    @DeleteMapping(value = "/myCourse/deletion/{id}")
    public CommonResult deleteUser(@PathVariable Long id) throws Exception{
        myCourseService.deleteMyCourse(id);
        return responseService.getSuccessfulResult();
    }


}
