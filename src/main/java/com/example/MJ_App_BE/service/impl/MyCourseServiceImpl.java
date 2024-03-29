package com.example.MJ_App_BE.service.impl;

import com.example.MJ_App_BE.data.dto.mycoursedto.GradeRequestDto;
import com.example.MJ_App_BE.data.dto.mycreditsdto.MyCreditsResponseDto;
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
import com.example.MJ_App_BE.data.dao.MyCourseDao;
import com.example.MJ_App_BE.data.dto.mycoursedto.MyCourseDto;
import com.example.MJ_App_BE.data.dto.mycoursedto.MyCourseResponseDto;
import com.example.MJ_App_BE.data.entity.*;
import com.example.MJ_App_BE.data.repository.*;
import com.example.MJ_App_BE.exception.UserException;

import java.util.ArrayList;
import java.util.List;

import static com.example.MJ_App_BE.data.entity.Ctype.*;
import static com.example.MJ_App_BE.data.entity.Grade.P;
import static com.example.MJ_App_BE.exception.ErrorCode.COURSE_NOT_FOUND;

@Service
public class MyCourseServiceImpl implements MyCourseService {

    private final MyCourseRepository myCourseRepository;
    private final UserRepository userRepository;
    private final MyCourseDao myCourseDao;
    private final CampusRepository campusRepository;
    private final CollegeRepository collegeRepository;
    private final MajorRepository majorRepository;
    private final UnivRepository univRepository;
    private final MyCreditsRepository myCreditsRepository;
    private final CreditsRepository creditsRepository;

    @Autowired
    public MyCourseServiceImpl(MyCourseDao myCourseDao, CollegeRepository collegeRepository, CampusRepository campusRepository,
                               MajorRepository majorRepository, UnivRepository univRepository, UserRepository userRepository,
                               MyCourseRepository myCourseRepository, MyCreditsRepository myCreditsRepository, CreditsRepository creditsRepository){
        this.myCourseDao = myCourseDao;
        this.collegeRepository = collegeRepository;
        this.campusRepository = campusRepository;
        this.majorRepository = majorRepository;
        this.univRepository = univRepository;
        this.userRepository = userRepository;
        this.myCourseRepository = myCourseRepository;
        this.myCreditsRepository = myCreditsRepository;
        this.creditsRepository = creditsRepository;
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
                int credits = course.getCredit(); // 강의의 credit(학점) 가져오기
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
                int credits = course.getCredit();
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
        return grade != P && grade != Grade.NP && grade != null;
    }


    @Override
    public MyCourseResponseDto saveCourse(MyCourseDto myCourseDto) {

        MyCourse myCourse = new MyCourse();

        myCourse.setYear(myCourseDto.getYear());
        myCourse.setSemester(myCourseDto.getSemester());
        myCourse.setGrade(myCourseDto.getGrade());
        myCourse.setCname(myCourseDto.getCname());
        myCourse.setCredit(myCourseDto.getCredit());
        myCourse.setCtype(myCourseDto.getCtype());

        User user = userRepository.findById(myCourseDto.getMyCourseUserId())
                .orElseThrow(() -> new UserException(COURSE_NOT_FOUND));
        myCourse.setUser(user);

        MyCourse savedCourse = myCourseDao.insertCourse(myCourse);

        MyCourseResponseDto myCourseResponseDto = new MyCourseResponseDto();

        myCourseResponseDto.setMyCourseId(savedCourse.getMyCourseId());
        myCourseResponseDto.setYear(savedCourse.getYear());
        myCourseResponseDto.setSemester(savedCourse.getSemester());
        myCourseResponseDto.setGrade(savedCourse.getGrade());
        myCourseResponseDto.setCname(savedCourse.getCname());
        myCourseResponseDto.setCredit(savedCourse.getCredit());
        myCourseResponseDto.setCtype(savedCourse.getCtype());
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
//        myCourseResponseDto.setMyCourseUserId(myCourse.getUser().getUserId());
//
//        return myCourseResponseDto;
//    }

    @Override
    public void deleteMyCourse(Long myCourseId) throws Exception {
        myCourseDao.deleteMyCourse(myCourseId);
    }

    @Override
    public List<MyCourseResponseDto> getSemesterCourse(Long userId, int year, Semester semester) {
        User user = userRepository.findByUserId(userId);
        List<MyCourse> myCourses = myCourseRepository.findByUserAndYearAndSemester(user, year, semester);


        List<MyCourseResponseDto> myCourseResponseDtos = new ArrayList<MyCourseResponseDto>();

        for(int i=0;i<myCourses.size();i++) {
            MyCourseResponseDto myCourseResponseDto = new MyCourseResponseDto();

            myCourseResponseDto.setMyCourseId(myCourses.get(i).getMyCourseId());
            myCourseResponseDto.setYear(myCourses.get(i).getYear());
            myCourseResponseDto.setSemester(myCourses.get(i).getSemester());
            myCourseResponseDto.setGrade(myCourses.get(i).getGrade());
            myCourseResponseDto.setCname(myCourses.get(i).getCname());
            myCourseResponseDto.setCredit(myCourses.get(i).getCredit());
            myCourseResponseDto.setCtype(myCourses.get(i).getCtype());
            myCourseResponseDto.setMyCourseUserId(myCourses.get(i).getUser().getUserId());

            myCourseResponseDtos.add(myCourseResponseDto);
        }

        return myCourseResponseDtos;
    }

    @Override
    @Transactional
    public MyCreditsResponseDto getAllCreditsByUser(Long userId) {
        User user = userRepository.findByUserId(userId);
        Credits credits = creditsRepository.findByMajorMajorId(user.getMajor().getMajorId());
        List<MyCourse> myCourses = myCourseRepository.findByUser(user);
        MyCredits myCredits = myCreditsRepository.findByUser(user).orElse(new MyCredits());

        // 0으로 초기화
        resetCredits(myCredits);

        MyCredits calculateCredits = calculateCredits(credits, myCourses, myCredits);
        myCredits.setUser(user);
        myCredits.updateMyCredits(calculateCredits);
        myCreditsRepository.save(myCredits);

        MyCreditsResponseDto responseDto = new MyCreditsResponseDto();
        responseDto.setMyCreditsId(myCredits.getMyCreditsId());
        responseDto.setMyCommonElectiveCredits(myCredits.getMyCommonElectiveCredits());
        responseDto.setMyCoreElectiveCredits(myCredits.getMyCoreElectiveCredits());
        responseDto.setMyCollegeElectiveCredits(myCredits.getMyCollegeElectiveCredits());
        responseDto.setMyGeneralElectiveCredits(myCredits.getMyGeneralElectiveCredits());
        responseDto.setMyMajorCredits(myCredits.getMyMajorCredits());
        responseDto.setMyFreeCredits(myCredits.getMyFreeCredits());
        responseDto.setMyTotalCredits(myCredits.getMyTotalCredits());
        responseDto.setMyChapel(myCredits.getMyChapel());
        responseDto.setMyCreditsUserId(myCredits.getUser().getUserId());
        return responseDto;
    }

    private void resetCredits(MyCredits myCredits) {
        myCredits.setMyCommonElectiveCredits(0);
        myCredits.setMyCoreElectiveCredits(0);
        myCredits.setMyCollegeElectiveCredits(0);
        myCredits.setMyGeneralElectiveCredits(0);
        myCredits.setMyMajorCredits(0);
        myCredits.setMyFreeCredits(0);
        myCredits.setMyChapel(0);
        myCredits.setMyTotalCredits(0);
    }

    private MyCredits calculateCredits(Credits credits, List<MyCourse> myCourses, MyCredits myCredits) {
        boolean addedChapelCredits = false;

        for (MyCourse course : myCourses) {
            if (course.getCtype() == Ctype.COMMON) {
                if (myCredits.getMyCommonElectiveCredits() == credits.getCommonElectiveCredits()) {
                    myCredits.setMyFreeCredits(myCredits.getMyFreeCredits() + course.getCredit());
                } else {
                    myCredits.setMyCommonElectiveCredits(myCredits.getMyCommonElectiveCredits() + course.getCredit());
                    if (myCredits.getMyCommonElectiveCredits() > credits.getCommonElectiveCredits()) {
                        int remainCredits = myCredits.getMyCommonElectiveCredits() - credits.getCommonElectiveCredits();
                        myCredits.setMyCommonElectiveCredits(credits.getCommonElectiveCredits());
                        myCredits.setMyFreeCredits(myCredits.getMyFreeCredits() + remainCredits);
                    }
                }
            } else if (course.getCtype() == CORE) {
                if (myCredits.getMyCoreElectiveCredits() == credits.getCoreElectiveCredits()) {
                    myCredits.setMyFreeCredits(myCredits.getMyFreeCredits() + course.getCredit());
                } else {
                    myCredits.setMyCoreElectiveCredits(myCredits.getMyCoreElectiveCredits() + course.getCredit());
                    if (myCredits.getMyCoreElectiveCredits() > credits.getCoreElectiveCredits()) {
                        int remainCredits = myCredits.getMyCoreElectiveCredits() - credits.getCoreElectiveCredits();
                        myCredits.setMyCoreElectiveCredits(credits.getCoreElectiveCredits());
                        myCredits.setMyFreeCredits(myCredits.getMyFreeCredits() + remainCredits);
                    }
                }
            } else if (course.getCtype() == COLLEGE) {
                if (myCredits.getMyCollegeElectiveCredits() == credits.getCollegeElectiveCredits()) {
                    myCredits.setMyFreeCredits(myCredits.getMyFreeCredits() + course.getCredit());
                } else {
                    myCredits.setMyCollegeElectiveCredits(myCredits.getMyCollegeElectiveCredits() + course.getCredit());
                    if (myCredits.getMyCollegeElectiveCredits() > credits.getCollegeElectiveCredits()) {
                        int remainCredits = myCredits.getMyCollegeElectiveCredits() - credits.getCollegeElectiveCredits();
                        myCredits.setMyFreeCredits(credits.getCollegeElectiveCredits());
                        myCredits.setMyFreeCredits(myCredits.getMyFreeCredits() + remainCredits);
                    }
                }
            } else if (course.getCtype() == GENERAL) {
                if (myCredits.getMyGeneralElectiveCredits() == credits.getGeneralElectiveCredits()) {
                    myCredits.setMyFreeCredits(myCredits.getMyFreeCredits() + course.getCredit());
                } else {
                    myCredits.setMyGeneralElectiveCredits(myCredits.getMyGeneralElectiveCredits() + course.getCredit());
                    if (myCredits.getMyGeneralElectiveCredits() > credits.getGeneralElectiveCredits()) {
                        int remainCredits = myCredits.getMyGeneralElectiveCredits() - credits.getGeneralElectiveCredits();
                        myCredits.setMyGeneralElectiveCredits(credits.getGeneralElectiveCredits());
                        myCredits.setMyFreeCredits(myCredits.getMyFreeCredits() + remainCredits);
                    }
                }
            } else if (course.getCtype() == MAJOR) {
                if (myCredits.getMyMajorCredits() == credits.getMajorCredits()) {
                    myCredits.setMyFreeCredits(myCredits.getMyFreeCredits() + course.getCredit());
                } else {
                    myCredits.setMyMajorCredits(myCredits.getMyMajorCredits() + course.getCredit());
                    if (myCredits.getMyMajorCredits() > credits.getMajorCredits()) {
                        int remainCredits = myCredits.getMyMajorCredits() - credits.getMajorCredits();
                        myCredits.setMyMajorCredits(credits.getMajorCredits());
                        myCredits.setMyFreeCredits(myCredits.getMyFreeCredits() + remainCredits);
                    }
                }
            } else if (course.getCtype() == CHAPEL) {
                // 채플은 횟수 카운트
                // 4회면 공통교양에 2학점 추가
                if (myCredits.getMyChapel() < 4) {
                    myCredits.setMyChapel(myCredits.getMyChapel() + 1);
                    if (myCredits.getMyChapel() == 4 && !addedChapelCredits) {
                        myCredits.setMyCommonElectiveCredits(myCredits.getMyCommonElectiveCredits() + 2);
                        addedChapelCredits = true;
                    }
                }
            }
        }
        myCredits.setMyTotalCredits(myCredits.getMyCommonElectiveCredits() + myCredits.getMyCoreElectiveCredits() + myCredits.getMyCollegeElectiveCredits() +
                myCredits.getMyGeneralElectiveCredits() + myCredits.getMyMajorCredits() + myCredits.getMyFreeCredits());
        return myCredits;
    }
}
