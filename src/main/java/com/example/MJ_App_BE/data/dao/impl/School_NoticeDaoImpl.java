package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.School_NoticeDao;
import com.example.MJ_App_BE.data.entity.School_Notice;
import com.example.MJ_App_BE.data.repository.School_NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class School_NoticeDaoImpl implements School_NoticeDao {

    private final School_NoticeRepository school_noticeRepository;

    @Autowired
    public School_NoticeDaoImpl(School_NoticeRepository school_noticeRepository) {
        this.school_noticeRepository = school_noticeRepository;
    }

    @Override
    public List<School_Notice> getAllNotices() {
        List<School_Notice> notices = school_noticeRepository.findAll();
        return notices;
    }
    @Override
    public List<School_Notice> getNoticesbyKeyword(String keyword) {
        List<School_Notice> notices = school_noticeRepository.findByKeyword(keyword);
        return notices;
    }

    @Override
    public School_Notice getRecent() {
        School_Notice notice = school_noticeRepository.findTopByOrderByPubDateDesc();
        return notice;
    }
}
