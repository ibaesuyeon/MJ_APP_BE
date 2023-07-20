package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.TestDao;
import com.example.MJ_App_BE.data.dao.UserDao;
import com.example.MJ_App_BE.data.entity.Test;
import com.example.MJ_App_BE.data.entity.User;
import com.example.MJ_App_BE.data.repository.TestRepository;
import com.example.MJ_App_BE.data.repository.UserRepository;
import com.example.MJ_App_BE.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.example.MJ_App_BE.exception.ErrorCode.USER_NOT_FOUND;

@Component
public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository;

    @Autowired
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User insertUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public User selectUser(Long id) {
        User selectedUser = userRepository.getReferenceById(id);
        return selectedUser;
    }

    @Override
    public User selectUserDevice(String deviceId) {
        User selectedUser = userRepository.findByDeviceId(deviceId);
        return selectedUser;
    }

    @Override
    public User updateUserYear(Long id, int year) throws UserException {
        User selectedUser = Optional.of(userRepository.getReferenceById(id))
                .orElseThrow(()-> new UserException(USER_NOT_FOUND));

        User updatedUser;
        User user = selectedUser;
        user.setYear(year);
        updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @Override
    public User updateUser(Long id, int year, int userCampusId, int userCollegeId, int userMajorId, int userUnivId) throws UserException {
        User selectedUser = Optional.of(userRepository.getReferenceById(id))
                .orElseThrow(()-> new UserException(USER_NOT_FOUND));

        User updatedUser;
        User user = selectedUser;
        user.setYear(year);
        user.setUserCampusId(userCampusId);
        user.setUserCollegeId(userCollegeId);
        user.setUserMajorId(userMajorId);
        user.setUserUnivId(userUnivId);
        updatedUser = userRepository.save(user);

        return updatedUser;
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> selectedUser = Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new UserException(USER_NOT_FOUND)));

        User user = selectedUser.get();
        userRepository.delete(user);
    }


}
