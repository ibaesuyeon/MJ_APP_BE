package com.example.MJ_App_BE.service.impl;

import com.example.MJ_App_BE.data.dao.UserDao;
import com.example.MJ_App_BE.data.dto.userdto.UserDto;
import com.example.MJ_App_BE.data.dto.userdto.UserResponseDto;
import com.example.MJ_App_BE.data.entity.User;
import com.example.MJ_App_BE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public UserResponseDto getUser(Long userId) {
        User user = userDao.selectUser(userId);

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setUserId(user.getUserId());
        userResponseDto.setUserCampusId(user.getUserCampusId());
        userResponseDto.setUserCollegeId(user.getUserCollegeId());
        userResponseDto.setUserMajorId(user.getUserMajorId());
        userResponseDto.setUserUnivId(user.getUserUnivId());
        userResponseDto.setYear(user.getYear());
        userResponseDto.setDeviceId(user.getDeviceId());


        return userResponseDto;
    }

    public UserResponseDto getUserDevice(String deviceId) {
        User user = userDao.selectUserDevice(deviceId);

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setUserId(user.getUserId());
        userResponseDto.setUserCampusId(user.getUserCampusId());
        userResponseDto.setUserCollegeId(user.getUserCollegeId());
        userResponseDto.setUserMajorId(user.getUserMajorId());
        userResponseDto.setUserUnivId(user.getUserUnivId());
        userResponseDto.setYear(user.getYear());
        userResponseDto.setDeviceId(user.getDeviceId());

        return userResponseDto;
    }

    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        User user = new User();
        user.setDeviceId(userDto.getDeviceId());
        user.setYear(userDto.getYear());
        user.setUserCampusId(userDto.getUserCampusId());
        user.setUserCollegeId(userDto.getUserCollegeId());
        user.setUserMajorId(userDto.getUserMajorId());
        user.setUserUnivId(userDto.getUserUnivId());


        User savedUser = userDao.insertUser(user);

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setUserId(savedUser.getUserId());
        userResponseDto.setDeviceId(savedUser.getDeviceId());
        userResponseDto.setYear(savedUser.getYear());
        userResponseDto.setUserCampusId(savedUser.getUserCampusId());
        userResponseDto.setUserCollegeId(savedUser.getUserCollegeId());
        userResponseDto.setUserMajorId(savedUser.getUserMajorId());
        userResponseDto.setUserUnivId(savedUser.getUserUnivId());

        return userResponseDto;
    }

    @Override@Transactional
    public UserResponseDto changeUserYear(Long userId, int year) throws Exception {

        User changedUser = userDao.updateUserYear(userId, year);

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setUserId(changedUser.getUserId());
        userResponseDto.setDeviceId(changedUser.getDeviceId());
        userResponseDto.setYear(changedUser.getYear());
        userResponseDto.setUserCampusId(changedUser.getUserCampusId());
        userResponseDto.setUserCollegeId(changedUser.getUserCollegeId());
        userResponseDto.setUserMajorId(changedUser.getUserMajorId());
        userResponseDto.setUserUnivId(changedUser.getUserUnivId());

        return userResponseDto;
    }

    @Override@Transactional
    public UserResponseDto changeUser(Long userId, int year, int userCampusId, int userCollegeId, int userMajorId, int userUnivId) throws Exception {

        User changedUser = userDao.updateUser(userId, year, userCampusId, userCollegeId, userMajorId, userUnivId);

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setUserId(changedUser.getUserId());
        userResponseDto.setDeviceId(changedUser.getDeviceId());
        userResponseDto.setYear(changedUser.getYear());
        userResponseDto.setUserCampusId(changedUser.getUserCampusId());
        userResponseDto.setUserCollegeId(changedUser.getUserCollegeId());
        userResponseDto.setUserMajorId(changedUser.getUserMajorId());
        userResponseDto.setUserUnivId(changedUser.getUserUnivId());

        return userResponseDto;
    }

    @Override
    public void deleteUser(Long userId) throws Exception {
        userDao.deleteUser(userId);
    }


}
