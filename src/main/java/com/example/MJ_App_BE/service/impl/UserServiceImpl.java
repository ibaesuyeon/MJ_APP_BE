package com.example.MJ_App_BE.service.impl;

import com.example.MJ_App_BE.data.dao.UserDao;
import com.example.MJ_App_BE.data.dto.userdto.UserDto;
import com.example.MJ_App_BE.data.dto.userdto.UserResponseDto;
import com.example.MJ_App_BE.data.entity.*;
import com.example.MJ_App_BE.data.repository.CampusRepository;
import com.example.MJ_App_BE.data.repository.CollegeRepository;
import com.example.MJ_App_BE.data.repository.MajorRepository;
import com.example.MJ_App_BE.data.repository.UnivRepository;
import com.example.MJ_App_BE.exception.UserException;
import com.example.MJ_App_BE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.MJ_App_BE.exception.ErrorCode.USER_NOT_FOUND;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final CampusRepository campusRepository;
    private final CollegeRepository collegeRepository;
    private final MajorRepository majorRepository;
    private final UnivRepository univRepository;

    @Autowired
    public UserServiceImpl(UserDao userDao, CollegeRepository collegeRepository, CampusRepository campusRepository,
                           MajorRepository majorRepository, UnivRepository univRepository){
        this.userDao = userDao;
        this.collegeRepository = collegeRepository;
        this.campusRepository = campusRepository;
        this.majorRepository = majorRepository;
        this.univRepository = univRepository;
    }

    @Override
    public UserResponseDto getUser(Long userId) {
        User user = userDao.selectUser(userId);

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setUserId(user.getUserId());
        userResponseDto.setUserCampusId(user.getCampus().getCampusId());
        userResponseDto.setUserCollegeId(user.getCollege().getCollegeId());
        userResponseDto.setUserMajorId(user.getMajor().getMajorId());
        userResponseDto.setUserUnivId(user.getUniv().getUnivId());
        userResponseDto.setYear(user.getYear());
        userResponseDto.setDeviceId(user.getDeviceId());


        return userResponseDto;
    }

    public UserResponseDto getUserDevice(String deviceId) {
        User user = userDao.selectUserDevice(deviceId);

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setUserId(user.getUserId());
        userResponseDto.setUserCampusId(user.getCampus().getCampusId());
        userResponseDto.setUserCollegeId(user.getCollege().getCollegeId());
        userResponseDto.setUserMajorId(user.getMajor().getMajorId());
        userResponseDto.setUserUnivId(user.getUniv().getUnivId());
        userResponseDto.setYear(user.getYear());
        userResponseDto.setDeviceId(user.getDeviceId());

        return userResponseDto;
    }

    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        User user = new User();
        user.setDeviceId(userDto.getDeviceId());
        user.setYear(userDto.getYear());

        Campus campus = campusRepository.findById(userDto.getUserCampusId())
                .orElseThrow(() -> new UserException(USER_NOT_FOUND));
        user.setCampus(campus);

        College college =collegeRepository.findById(userDto.getUserCollegeId())
                .orElseThrow(() -> new UserException(USER_NOT_FOUND));
        user.setCollege(college);

        Major major = majorRepository.findById(userDto.getUserMajorId())
                .orElseThrow(() -> new UserException(USER_NOT_FOUND));
        user.setMajor(major);

        Univ univ = univRepository.findById(userDto.getUserUnivId())
                .orElseThrow(() -> new UserException(USER_NOT_FOUND));
        user.setUniv(univ);

        User savedUser = userDao.insertUser(user);

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setUserId(savedUser.getUserId());
        userResponseDto.setDeviceId(savedUser.getDeviceId());
        userResponseDto.setYear(savedUser.getYear());
        userResponseDto.setUserCampusId(savedUser.getCampus().getCampusId());
        userResponseDto.setUserCollegeId(savedUser.getCollege().getCollegeId());
        userResponseDto.setUserMajorId(savedUser.getMajor().getMajorId());
        userResponseDto.setUserUnivId(savedUser.getUniv().getUnivId());


        return userResponseDto;
    }

    @Override@Transactional
    public UserResponseDto changeUserYear(Long userId, int year) throws Exception {

        User changedUser = userDao.updateUserYear(userId, year);

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setUserId(changedUser.getUserId());
        userResponseDto.setDeviceId(changedUser.getDeviceId());
        userResponseDto.setYear(changedUser.getYear());
        userResponseDto.setUserCampusId(changedUser.getCampus().getCampusId());
        userResponseDto.setUserCollegeId(changedUser.getCollege().getCollegeId());
        userResponseDto.setUserMajorId(changedUser.getMajor().getMajorId());
        userResponseDto.setUserUnivId(changedUser.getUniv().getUnivId());

        return userResponseDto;
    }

    @Override @Transactional
    public UserResponseDto changeUser(Long userId, int year, Long userCampusId, Long userCollegeId, Long userMajorId, Long userUnivId) throws Exception {

        User changedUser = userDao.updateUser(userId, year, userCampusId, userCollegeId, userMajorId, userUnivId);

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setUserId(changedUser.getUserId());
        userResponseDto.setDeviceId(changedUser.getDeviceId());
        userResponseDto.setYear(changedUser.getYear());
        userResponseDto.setUserCampusId(changedUser.getCampus().getCampusId());
        userResponseDto.setUserCollegeId(changedUser.getCollege().getCollegeId());
        userResponseDto.setUserMajorId(changedUser.getMajor().getMajorId());
        userResponseDto.setUserUnivId(changedUser.getUniv().getUnivId());

        return userResponseDto;
    }

    @Override
    public void deleteUser(Long userId) throws Exception {
        userDao.deleteUser(userId);
    }


}
