package com.example.MJ_App_BE.service.impl;

import com.example.MJ_App_BE.data.dao.TestDao;
import com.example.MJ_App_BE.data.dto.testdto.TestResponseDto;
import com.example.MJ_App_BE.data.entity.Test;
import com.example.MJ_App_BE.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    private final TestDao testDao;

    @Autowired
    public TestServiceImpl(TestDao testDao){
        this.testDao = testDao;
    }

    @Override
    public TestResponseDto getTest(int id) {
        Test test = testDao.selectTest(id);

        TestResponseDto testResponseDto = new TestResponseDto();

        testResponseDto.setId(test.getId());
        testResponseDto.setCampusName(test.getCampusName());
        testResponseDto.setCampusUnivId(test.getCampusUnivId());


        return testResponseDto;
    }

}
