package com.example.MJ_App_BE.service.impl;

import com.example.MJ_App_BE.data.dao.CreditsDao;
import com.example.MJ_App_BE.data.dto.creditsdto.CreditsDto;
import com.example.MJ_App_BE.data.dto.creditsdto.CreditsResponseDto;
import com.example.MJ_App_BE.data.entity.Credits;
import com.example.MJ_App_BE.data.entity.User;
import com.example.MJ_App_BE.data.repository.CreditsRepository;
import com.example.MJ_App_BE.data.repository.UserRepository;
import com.example.MJ_App_BE.service.CreditsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditsServiceImpl implements CreditsService {

    private final CreditsDao creditsDao;
    private final UserRepository userRepository;
    private final CreditsRepository creditsRepository;


    @Autowired
    public CreditsServiceImpl(CreditsDao creditsDao, UserRepository userRepository, CreditsRepository creditsRepository){
        this.creditsDao = creditsDao;
        this.userRepository = userRepository;
        this.creditsRepository = creditsRepository;
    }

    @Override
    public CreditsDto getCreditsByMajorId(Long userId) {   // or User 객체?
        User user = userRepository.findByUserId(userId);
        Long majorId = user.getMajor().getMajorId();

        Credits credits = creditsRepository.findByMajorMajorId(majorId);
        return new CreditsDto(credits);
    }

    @Override
    public CreditsResponseDto getCredits(Long creditsMajorId) {

        Credits credits = creditsDao.getCredits(creditsMajorId);

        CreditsResponseDto creditsResponseDto = new CreditsResponseDto();

        creditsResponseDto.setCreditsId(credits.getCreditsId());
        creditsResponseDto.setTotalCredits(credits.getTotalCredits());
        creditsResponseDto.setCommonElectiveCredits(credits.getCommonElectiveCredits());
        creditsResponseDto.setCoreElectiveCredits(credits.getCoreElectiveCredits());
        creditsResponseDto.setCollegeElectiveCredits(credits.getCollegeElectiveCredits());
        creditsResponseDto.setMajorCredits(credits.getMajorCredits());
        creditsResponseDto.setGeneralElectiveCredits(credits.getGeneralElectiveCredits());
        creditsResponseDto.setFreeCredits(credits.getFreeCredits());
        creditsResponseDto.setChapel(credits.getChapel());
        creditsResponseDto.setCreditsMajorId(credits.getMajor().getMajorId());


        return creditsResponseDto;
    }

}
