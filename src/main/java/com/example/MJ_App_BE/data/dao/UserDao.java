package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.entity.User;
import com.example.MJ_App_BE.exception.UserException;

public interface UserDao {
    User insertUser(User user);
    User selectUser(int id);
    User updateUserYear(int id, int year) throws UserException;
    void deleteUser(int id) throws UserException;
}
