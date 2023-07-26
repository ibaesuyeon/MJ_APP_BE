package com.example.MJ_App_BE.service.impl;

import com.example.MJ_App_BE.data.dao.CreditsDao;
import com.example.MJ_App_BE.data.dto.creditsdto.CreditsResponseDto;
import com.example.MJ_App_BE.data.dto.userdto.UserResponseDto;
import com.example.MJ_App_BE.data.entity.Credits;
import com.example.MJ_App_BE.data.entity.User;
import com.example.MJ_App_BE.service.CreditsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditsServiceImpl implements CreditsService {

    private final CreditsDao creditsDao;

    @Autowired
    public CreditsServiceImpl(CreditsDao creditsDao){
        this.creditsDao = creditsDao;
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
        creditsResponseDto.setCreditsMajorId(credits.getCreditsMajorId());


        return creditsResponseDto;
    }

}
