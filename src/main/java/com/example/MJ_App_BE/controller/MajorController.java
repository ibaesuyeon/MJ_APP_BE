package com.example.MJ_App_BE.controller;


import com.example.MJ_App_BE.Result.CommonResult;
import com.example.MJ_App_BE.Result.ResponseService;
import com.example.MJ_App_BE.data.dto.majordto.MajorResponseDto;
import com.example.MJ_App_BE.data.dto.userdto.ChangeUserDto;
import com.example.MJ_App_BE.data.dto.userdto.ChangeUserYearDto;
import com.example.MJ_App_BE.data.dto.userdto.UserDto;
import com.example.MJ_App_BE.data.dto.userdto.UserResponseDto;
import com.example.MJ_App_BE.service.MajorService;
import com.example.MJ_App_BE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/major")
@CrossOrigin(origins = "*")

public class MajorController {

    private final MajorService majorService;
    private final ResponseService responseService;

    @Autowired
    public MajorController(MajorService majorService, ResponseService responseService) {
        this.majorService = majorService;
        this.responseService = responseService;
    }

    //user id로 가져오기
    @GetMapping(value = "/major/{id}")
    public CommonResult getTest(@PathVariable Long id) {
        MajorResponseDto majorOne = majorService.getMajor(id);
        CommonResult commonResult = responseService.getSingleResult(majorOne);
        return commonResult;
    }


}
