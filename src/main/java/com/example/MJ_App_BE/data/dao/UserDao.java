package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.entity.User;
import com.example.MJ_App_BE.exception.UserException;

public interface UserDao {
    User insertUser(User user);
    User selectUser(Long id);

    User selectUserDevice(String deviceId);
    User updateUserYear(Long id, int year) throws UserException;

    User updateUser(Long id, int year, Long userCampusId, Long userCollegeId, Long userMajorId, Long userUnivId) throws UserException;
    void deleteUser(Long id) throws UserException;
}
