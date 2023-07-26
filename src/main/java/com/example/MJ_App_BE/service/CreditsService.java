package com.example.MJ_App_BE.service;

import com.example.MJ_App_BE.data.dto.creditsdto.CreditsResponseDto;
import com.example.MJ_App_BE.data.dto.userdto.UserDto;
import com.example.MJ_App_BE.data.dto.userdto.UserResponseDto;

public interface CreditsService {

    CreditsResponseDto getCredits(Long creditsMajorId);
}
