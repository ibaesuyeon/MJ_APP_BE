package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.entity.Test;

public interface TestDao {
    Test insertTest(Test test);
    Test selectTest(int id);
    Test updateTestInfo(int id, String campusName, int campusUnivId) throws Exception;
    void deleteTest(int id) throws Exception;
}
