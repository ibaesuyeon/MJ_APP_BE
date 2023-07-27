package com.example.MJ_App_BE.service;

import com.example.MJ_App_BE.data.dto.creditsdto.CreditsDto;
import com.example.MJ_App_BE.data.dto.creditsdto.CreditsResponseDto;

public interface CreditsService {

    CreditsResponseDto getCredits(Long creditsMajorId);

    CreditsDto getCreditsByMajorId(Long userId);
}
