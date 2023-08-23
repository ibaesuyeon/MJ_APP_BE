package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.Ict_NoticeDao;
import com.example.MJ_App_BE.data.entity.Ict_Notice;
import com.example.MJ_App_BE.data.repository.Ict_NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Ict_NoticeDaoImpl implements Ict_NoticeDao {

    private final Ict_NoticeRepository ict_noticeRepository;

    @Autowired
    public Ict_NoticeDaoImpl(Ict_NoticeRepository ict_noticeRepository) {
        this.ict_noticeRepository = ict_noticeRepository;
    }

    @Override
    public List<Ict_Notice> getAllNotices() {
        List<Ict_Notice> notices = ict_noticeRepository.findAll();
        return notices;
    }
    @Override
    public List<Ict_Notice> getNoticesbyKeyword(String keyword) {
        List<Ict_Notice> notices = ict_noticeRepository.findByKeyword(keyword);
        return notices;
    }

    @Override
    public Ict_Notice getRecent() {
        Ict_Notice notice = ict_noticeRepository.findTopByOrderByPubDateDesc();
        return notice;
    }
}
