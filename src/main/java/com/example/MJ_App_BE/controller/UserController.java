package com.example.MJ_App_BE.controller;


import com.example.MJ_App_BE.Result.CommonResult;
import com.example.MJ_App_BE.Result.ResponseService;
import com.example.MJ_App_BE.data.dto.userdto.ChangeUserDto;
import com.example.MJ_App_BE.data.dto.userdto.ChangeUserYearDto;
import com.example.MJ_App_BE.data.dto.userdto.UserDto;
import com.example.MJ_App_BE.data.dto.userdto.UserResponseDto;
import com.example.MJ_App_BE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/user")
@CrossOrigin(origins = "*")

public class UserController {

    private final UserService userService;
    private final ResponseService responseService;

    @Autowired
    public UserController(UserService userService, ResponseService responseService) {
        this.userService = userService;
        this.responseService = responseService;
    }

    //user id로 가져오기
    @GetMapping(value = "/user/{id}")
    public CommonResult getTest(@PathVariable Long id) {
        UserResponseDto userOne = userService.getUser(id);
        CommonResult commonResult = responseService.getSingleResult(userOne);
        return commonResult;
    }

    //user device id로 가져오기
    @GetMapping(value = "/user/device/{deviceId}")
    public CommonResult getUser(@PathVariable String deviceId) {
        UserResponseDto userOne = userService.getUserDevice(deviceId);
        CommonResult commonResult = responseService.getSingleResult(userOne);
        return commonResult;
    }

    //user 등록하기
    @PostMapping(value = "/user/register")
    public CommonResult createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);

        return responseService.getSuccessfulResult();
    }

    //user 학년 수정하기
    @PutMapping(value = "/user/modifyYear/{id}")
    public CommonResult changeUserYear(
            @PathVariable Long id, @RequestBody ChangeUserYearDto changeUserYearDto) throws Exception{
        userService.changeUserYear(id, changeUserYearDto.getYear());

        return responseService.getSuccessfulResult();
    }

    //user 정보 수정하기
    @PutMapping(value = "/user/modify/{id}")
    public CommonResult changeUser(
            @PathVariable Long id, @RequestBody ChangeUserDto changeUserDto) throws Exception{
        userService.changeUser(id, changeUserDto.getYear(), changeUserDto.getUserCampusId(), changeUserDto.getUserCollegeId(), changeUserDto.getUserMajorId(), changeUserDto.getUserUnivId());

        return responseService.getSuccessfulResult();
    }

    //user 삭제하기
    @DeleteMapping(value = "/user/deletion/{id}")
    public CommonResult deleteUser(@PathVariable Long id) throws Exception{
        userService.deleteUser(id);
        return responseService.getSuccessfulResult();
    }
}
