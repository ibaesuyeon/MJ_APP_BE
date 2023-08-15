package com.example.MJ_App_BE.service.impl;

import com.example.MJ_App_BE.data.dao.MyCourseDao;
import com.example.MJ_App_BE.data.dto.mycoursedto.MyCourseDto;
import com.example.MJ_App_BE.data.dto.mycoursedto.MyCourseResponseDto;
import com.example.MJ_App_BE.data.entity.*;
import com.example.MJ_App_BE.data.repository.*;
import com.example.MJ_App_BE.exception.UserException;
import com.example.MJ_App_BE.service.MyCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.MJ_App_BE.exception.ErrorCode.COURSE_NOT_FOUND;

@Service
public class MyCourseServiceImpl implements MyCourseService {

    private final MyCourseDao myCourseDao;
    private final CampusRepository campusRepository;
    private final CollegeRepository collegeRepository;
    private final MajorRepository majorRepository;
    private final UnivRepository univRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Autowired
    public MyCourseServiceImpl(MyCourseDao myCourseDao, CollegeRepository collegeRepository, CampusRepository campusRepository,
                               MajorRepository majorRepository, UnivRepository univRepository, CourseRepository courseRepository, UserRepository userRepository){
        this.myCourseDao = myCourseDao;
        this.collegeRepository = collegeRepository;
        this.campusRepository = campusRepository;
        this.majorRepository = majorRepository;
        this.univRepository = univRepository;
        this.courseRepository =courseRepository;
        this.userRepository = userRepository;
    }


    @Override
    public MyCourseResponseDto saveCourse(MyCourseDto myCourseDto) {

        MyCourse myCourse = new MyCourse();

        myCourse.setYear(myCourseDto.getYear());
        myCourse.setSemester(myCourseDto.getSemester());
        myCourse.setGrade(myCourseDto.getGrade());
        myCourse.setDetails(myCourseDto.getDetails());

        Course course = courseRepository.findById(myCourseDto.getMyCourseCourseId())
                .orElseThrow(() -> new UserException(COURSE_NOT_FOUND));
        myCourse.setCourse(course);

        User user = userRepository.findById(myCourseDto.getMyCourseUserId())
                .orElseThrow(() -> new UserException(COURSE_NOT_FOUND));
        myCourse.setUser(user);

        MyCourse savedCourse = myCourseDao.insertCourse(myCourse);

        MyCourseResponseDto myCourseResponseDto = new MyCourseResponseDto();

        myCourseResponseDto.setMyCourseId(savedCourse.getMyCourseId());
        myCourseResponseDto.setYear(savedCourse.getYear());
        myCourseResponseDto.setSemester(savedCourse.getSemester());
        myCourseResponseDto.setGrade(savedCourse.getGrade());
        myCourseResponseDto.setDetails(savedCourse.getDetails());
        myCourseResponseDto.setMyCourseCourseId(savedCourse.getCourse().getCourseId());
        myCourseResponseDto.setMyCourseUserId(savedCourse.getUser().getUserId());



        return myCourseResponseDto;
    }

//    @Override
//    public List<MyCourseResponseDto> getMyCourse(Long myCourseUserId) {
//        MyCourse myCourse = myCourseDao.selectMyCourseUserId(myCourseUserId);
//
//        MyCourseResponseDto myCourseResponseDto = new MyCourseResponseDto();
//
//        myCourseResponseDto.setMyCourseId(myCourse.getMyCourseId());
//        myCourseResponseDto.setYear(myCourse.getYear());
//        myCourseResponseDto.setSemester(myCourse.getSemester());
//        myCourseResponseDto.setGrade(myCourse.getGrade());
//        myCourseResponseDto.setDetails(myCourse.getDetails());
//        myCourseResponseDto.setMyCourseCourseId(myCourse.getCourse().getCourseId());
//        myCourseResponseDto.setMyCourseUserId(myCourse.getUser().getUserId());
//
//        return myCourseResponseDto;
//    }

    @Override
    public void deleteMyCourse(Long myCourseId) throws Exception {
        myCourseDao.deleteMyCourse(myCourseId);
    }
}
