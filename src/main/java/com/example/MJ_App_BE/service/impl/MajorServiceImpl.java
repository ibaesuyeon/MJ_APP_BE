package com.example.MJ_App_BE.service.impl;

import com.example.MJ_App_BE.data.dao.MajorDao;
import com.example.MJ_App_BE.data.dto.majordto.MajorResponseDto;
import com.example.MJ_App_BE.data.entity.*;
import com.example.MJ_App_BE.data.repository.CampusRepository;
import com.example.MJ_App_BE.data.repository.CollegeRepository;
import com.example.MJ_App_BE.data.repository.MajorRepository;
import com.example.MJ_App_BE.data.repository.UnivRepository;
import com.example.MJ_App_BE.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorServiceImpl implements MajorService {

    private final MajorDao majorDao;
    private final CampusRepository campusRepository;
    private final CollegeRepository collegeRepository;
    private final MajorRepository majorRepository;
    private final UnivRepository univRepository;

    @Autowired
    public MajorServiceImpl(MajorDao majorDao, CollegeRepository collegeRepository, CampusRepository campusRepository,
                            MajorRepository majorRepository, UnivRepository univRepository){
        this.majorDao = majorDao;
        this.collegeRepository = collegeRepository;
        this.campusRepository = campusRepository;
        this.majorRepository = majorRepository;
        this.univRepository = univRepository;
    }

    @Override
    public MajorResponseDto getMajor(Long majorId) {
        Major major = majorDao.selectMajor(majorId);

        MajorResponseDto majorResponseDto = new MajorResponseDto();

        majorResponseDto.setMajorId(major.getMajorId());
        majorResponseDto.setMajorName(major.getMajorName());
        majorResponseDto.setMajorCollegeId(major.getCollege().getCollegeId());


        return majorResponseDto;
    }

}
