package com.example.MJ_App_BE.service;

import com.example.MJ_App_BE.data.dto.userdto.UserDto;
import com.example.MJ_App_BE.data.dto.userdto.UserResponseDto;

public interface UserService {

    UserResponseDto getUser(int userId);

    UserResponseDto saveUser(UserDto userDto);

    UserResponseDto changeUserYear(int userId, int year) throws Exception;

    void deleteUser(int userId) throws Exception;
}
