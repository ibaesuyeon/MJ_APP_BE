package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.Edu_NoticeDao;
import com.example.MJ_App_BE.data.entity.Edu_Notice;
import com.example.MJ_App_BE.data.repository.Edu_NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Edu_NoticeDaoImpl implements Edu_NoticeDao {

    private final Edu_NoticeRepository edu_noticeRepository;

    @Autowired
    public Edu_NoticeDaoImpl(Edu_NoticeRepository edu_noticeRepository) {
        this.edu_noticeRepository = edu_noticeRepository;
    }

    @Override
    public List<Edu_Notice> getAllNotices() {
        List<Edu_Notice> notices = edu_noticeRepository.findAll();
        return notices;
    }
    @Override
    public List<Edu_Notice> getNoticesbyKeyword(String keyword) {
        List<Edu_Notice> notices = edu_noticeRepository.findByKeyword(keyword);
        return notices;
    }

    @Override
    public Edu_Notice getRecent() {
        Edu_Notice notice = edu_noticeRepository.findTopByOrderByPubDateDesc();
        return notice;
    }
}
