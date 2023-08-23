package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.Business_NoticeDao;
import com.example.MJ_App_BE.data.entity.Business_Notice;
import com.example.MJ_App_BE.data.repository.Business_NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Business_NoticeDaoImpl implements Business_NoticeDao {

    private final Business_NoticeRepository business_noticeRepository;

    @Autowired
    public Business_NoticeDaoImpl(Business_NoticeRepository business_noticeRepository) {
        this.business_noticeRepository = business_noticeRepository;
    }

    @Override
    public List<Business_Notice> getAllNotices() {
        List<Business_Notice> notices = business_noticeRepository.findAll();
        return notices;
    }
    @Override
    public List<Business_Notice> getNoticesbyKeyword(String keyword) {
        List<Business_Notice> notices = business_noticeRepository.findByKeyword(keyword);
        return notices;
    }

    @Override
    public Business_Notice getRecent() {
        Business_Notice notice = business_noticeRepository.findTopByOrderByPubDateDesc();
        return notice;
    }
}
