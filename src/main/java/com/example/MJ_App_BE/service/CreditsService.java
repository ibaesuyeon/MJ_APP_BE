package com.example.MJ_App_BE.service;

import com.example.MJ_App_BE.data.dto.creditsdto.CreditsDto;
import com.example.MJ_App_BE.data.entity.Credits;
import com.example.MJ_App_BE.data.entity.User;
import com.example.MJ_App_BE.data.repository.CreditsRepository;
import com.example.MJ_App_BE.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditsService {

    private final CreditsRepository creditsRepository;
    private final UserRepository userRepository;

    public CreditsDto getCreditsByMajorId(Long userId) {   // or User 객체?
        User user = userRepository.findByUserId(userId);
        Long majorId = user.getMajor().getMajorId();

        Credits credits = creditsRepository.findByMajorMajorId(majorId);
        return new CreditsDto(credits);
    }
}
