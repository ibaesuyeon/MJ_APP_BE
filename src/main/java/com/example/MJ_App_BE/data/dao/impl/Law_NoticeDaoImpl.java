package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.Law_NoticeDao;
import com.example.MJ_App_BE.data.entity.Law_Notice;
import com.example.MJ_App_BE.data.repository.Law_NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Law_NoticeDaoImpl implements Law_NoticeDao {

    private final Law_NoticeRepository law_noticeRepository;

    @Autowired
    public Law_NoticeDaoImpl(Law_NoticeRepository law_noticeRepository) {
        this.law_noticeRepository = law_noticeRepository;
    }

    @Override
    public List<Law_Notice> getAllNotices() {
        List<Law_Notice> notices = law_noticeRepository.findAll();
        return notices;
    }
    @Override
    public List<Law_Notice> getNoticesbyKeyword(String keyword) {
        List<Law_Notice> notices = law_noticeRepository.findByKeyword(keyword);
        return notices;
    }

    @Override
    public Law_Notice getRecent() {
        Law_Notice notice = law_noticeRepository.findTopByOrderByPubDateDesc();
        return notice;
    }
}
