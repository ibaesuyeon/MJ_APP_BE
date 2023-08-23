package com.example.MJ_App_BE.service;

import com.example.MJ_App_BE.data.dto.majordto.MajorResponseDto;

public interface MajorService {

    MajorResponseDto getMajor(Long majorId);

}
