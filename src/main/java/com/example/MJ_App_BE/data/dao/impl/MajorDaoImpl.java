package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.MajorDao;
import com.example.MJ_App_BE.data.dao.UserDao;
import com.example.MJ_App_BE.data.entity.*;
import com.example.MJ_App_BE.data.repository.*;
import com.example.MJ_App_BE.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.example.MJ_App_BE.exception.ErrorCode.USER_NOT_FOUND;

@Component
public class MajorDaoImpl implements MajorDao {

    private final UserRepository userRepository;
    private final CampusRepository campusRepository;
    private final CollegeRepository collegeRepository;
    private final MajorRepository majorRepository;
    private final UnivRepository univRepository;

    @Autowired
    public MajorDaoImpl(UserRepository userRepository, CampusRepository campusRepository, CollegeRepository collegeRepository,
                        MajorRepository majorRepository, UnivRepository univRepository) {
        this.userRepository = userRepository;
        this.campusRepository = campusRepository;
        this.collegeRepository = collegeRepository;
        this.majorRepository = majorRepository;
        this.univRepository = univRepository;
    }


    @Override
    public Major selectMajor(Long id) {
        Major selectedUser = majorRepository.getReferenceById(id);
        return selectedUser;
    }



}
