package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.CreditsDao;
import com.example.MJ_App_BE.data.entity.Credits;
import com.example.MJ_App_BE.data.repository.CreditsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CreditsDaoImpl implements CreditsDao {

    private final CreditsRepository creditsRepository;

    @Autowired
    public CreditsDaoImpl(CreditsRepository creditsRepository) {
        this.creditsRepository = creditsRepository;
    }


    @Override
    public Credits getCredits(Long creditsMajorId) {
        Credits selectedCredits = creditsRepository.findByMajorMajorId(creditsMajorId);
        return selectedCredits;
    }
}
