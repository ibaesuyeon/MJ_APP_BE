package com.example.MJ_App_BE.service;

import com.example.MJ_App_BE.data.dto.testdto.TestResponseDto;

public interface TestService {

    TestResponseDto getTest(int id);
}
