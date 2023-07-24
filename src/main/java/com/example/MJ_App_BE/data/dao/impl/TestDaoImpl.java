package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.TestDao;
import com.example.MJ_App_BE.data.entity.Test;
import com.example.MJ_App_BE.data.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestDaoImpl implements TestDao {

    private final TestRepository testRepository;

    @Autowired
    public TestDaoImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }


    @Override
    public Test insertTest(Test test) {
        return null;
    }

    @Override
    public Test selectTest(int id) {
        Test selectedTest = testRepository.getReferenceById(id);
        return selectedTest;
    }

    @Override
    public Test updateTestInfo(int id, String campusName, int campusUnivId) throws Exception {
        return null;
    }

    @Override
    public void deleteTest(int id) throws Exception {

    }


}
