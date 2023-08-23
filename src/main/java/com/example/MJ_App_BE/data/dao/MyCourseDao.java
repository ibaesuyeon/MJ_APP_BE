package com.example.MJ_App_BE.data.dao;


import com.example.MJ_App_BE.data.entity.MyCourse;
import com.example.MJ_App_BE.data.entity.Semester;
import com.example.MJ_App_BE.exception.UserException;

import java.util.List;

public interface MyCourseDao {

    MyCourse insertCourse(MyCourse myCourse);

//    MyCourse selectMyCourseUserId(Long myCourseUserId);

    void deleteMyCourse(Long myCourseId) throws UserException;

}
