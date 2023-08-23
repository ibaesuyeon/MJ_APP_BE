package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.MyCourseDao;
import com.example.MJ_App_BE.data.dao.UserDao;
import com.example.MJ_App_BE.data.entity.*;
import com.example.MJ_App_BE.data.repository.*;
import com.example.MJ_App_BE.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.example.MJ_App_BE.exception.ErrorCode.COURSE_NOT_FOUND;
import static com.example.MJ_App_BE.exception.ErrorCode.USER_NOT_FOUND;

@Component
public class MyCourseDaoImpl implements MyCourseDao {

    private final UserRepository userRepository;
    private final CampusRepository campusRepository;
    private final CollegeRepository collegeRepository;
    private final MajorRepository majorRepository;
    private final UnivRepository univRepository;
    private final MyCourseRepository myCourseRepository;

    @Autowired
    public MyCourseDaoImpl(UserRepository userRepository, CampusRepository campusRepository, CollegeRepository collegeRepository,
                           MajorRepository majorRepository, UnivRepository univRepository, MyCourseRepository myCourseRepository) {
        this.userRepository = userRepository;
        this.campusRepository = campusRepository;
        this.collegeRepository = collegeRepository;
        this.majorRepository = majorRepository;
        this.univRepository = univRepository;
        this.myCourseRepository = myCourseRepository;
    }


    @Override
    public MyCourse insertCourse(MyCourse myCourse) {
        MyCourse savedCourse = myCourseRepository.save(myCourse);
        return savedCourse;
    }

//    @Override
//    public MyCourse selectMyCourseUserId(Long myCourseUserId) {
//        MyCourse selectedCourse = myCourseRepository.findByCourseUserId(myCourseUserId);
//        return selectedCourse;
//    }

    @Override
    public void deleteMyCourse(Long myCourseId) throws UserException {
        Optional<MyCourse> selectedMyCourse = Optional.ofNullable(myCourseRepository.findById(myCourseId)
                .orElseThrow(() -> new UserException(COURSE_NOT_FOUND)));

        MyCourse myCourse = selectedMyCourse.get();
        myCourseRepository.delete(myCourse);
    }

}
