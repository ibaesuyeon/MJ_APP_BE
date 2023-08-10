package com.example.MJ_App_BE.service.impl;

import com.example.MJ_App_BE.data.dto.mycoursedto.GradeRequestDto;
import com.example.MJ_App_BE.data.entity.Grade;
import com.example.MJ_App_BE.data.entity.MyCourse;
import com.example.MJ_App_BE.data.entity.Semester;
import com.example.MJ_App_BE.data.entity.User;
import com.example.MJ_App_BE.data.repository.MyCourseRepository;
import com.example.MJ_App_BE.data.repository.UserRepository;
import com.example.MJ_App_BE.service.MyCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MyCourseServiceImpl implements MyCourseService {

    private final MyCourseRepository myCourseRepository;
    private final UserRepository userRepository;

    @Autowired
    public MyCourseServiceImpl(MyCourseRepository myCourseRepository, UserRepository userRepository) {
        this.myCourseRepository = myCourseRepository;
        this.userRepository = userRepository;
    }

    // 학점 입력
    @Override
    @Transactional
    public void setGradeMyCourse(GradeRequestDto gradeRequestDto) {
        MyCourse myCourse = myCourseRepository.findById(gradeRequestDto.getMyCourseId())
                .orElseThrow(() -> new RuntimeException("해당 강의가 존재하지 않습니다."));

        myCourse.setGrade(gradeRequestDto.getGrade());
        myCourseRepository.save(myCourse);
    }

    // n학년 n학기 평균학점

    // 전체 평균학점
    @Override
    public double calculateAllAverageGrade(Long userId) {
        User user = userRepository.findByUserId(userId);
        List<MyCourse> userCourses = myCourseRepository.findByUser(user);

        int totalCredits = 0;  // 총 학점
        double totalGrades = 0.0;  // 성적 총합

        for (MyCourse course : userCourses) {
            Grade grade = course.getGrade();
            if (isNumericGrade(grade)) {
                int credits = course.getCourse().getCredit(); // 강의의 credit(학점) 가져오기
                double gradePoint = convertGradeToGradePoint(grade);

                totalCredits += credits;
                totalGrades += credits * gradePoint;
            }
        }

        double averageGrade = totalGrades / totalCredits;
        return Math.round(averageGrade * 100.0) / 100.0;
    }

    @Override
    public double calculateAverageGradeYearAndSemester(Long userId, int year, Semester semester) {
        User user = userRepository.findByUserId(userId);
        List<MyCourse> userCourses = myCourseRepository.findByUserAndYearAndSemester(user, year, semester);

        int totalCredits = 0;
        double totalGrades = 0.0;

        for (MyCourse course : userCourses) {
            Grade grade = course.getGrade();
            if (isNumericGrade(grade)) {
                int credits = course.getCourse().getCredit();
                double gradePoint = convertGradeToGradePoint(grade);

                totalCredits += credits;
                totalGrades += credits * gradePoint;
            }
        }

        if (totalCredits == 0) {
            return 0.0;
        }

        double averageGrade = totalGrades / totalCredits;
        return Math.round(averageGrade * 100.0) / 100.0;
    }

    private double convertGradeToGradePoint(Grade grade) {
        switch (grade) {
            case A_PLUS:
                return 4.5;
            case A0:
                return 4.0;
            case B_PLUS:
                return 3.5;
            case B0:
                return 3.0;
            case C_PLUS:
                return 2.5;
            case C0:
                return 2.0;
            case D_PLUS:
                return 1.5;
            case D0:
                return 1.0;
            case F:
                return 0.0;
            default:
                return 0.0;
        }
    }

    private boolean isNumericGrade(Grade grade) {
        // 패논패 강의는 학점 계산에 포함하지 않음
        // grade가 null인 강의는 포함하지 않음
        return grade != Grade.P && grade != Grade.NP && grade != null;
    }

}
