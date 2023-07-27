package com.example.MJ_App_BE.service;

import com.example.MJ_App_BE.Result.CommonResult;
import com.example.MJ_App_BE.data.dto.userdto.UserDto;
import com.example.MJ_App_BE.data.dto.userdto.UserResponseDto;

public interface UserService {

    UserResponseDto getUser(Long userId);

    UserResponseDto getUserDevice(String deviceId);

    UserResponseDto saveUser(UserDto userDto);

    UserResponseDto changeUserYear(Long userId, int year) throws Exception;

    UserResponseDto changeUser(Long userId, int year, Long userCampusId, Long userCollegeId, Long userMajorId, Long userUnivId) throws Exception;
    void deleteUser(Long userId) throws Exception;
}
