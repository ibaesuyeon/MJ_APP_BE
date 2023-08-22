package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.NoticeDao;
import com.example.MJ_App_BE.data.entity.Notice;
import com.example.MJ_App_BE.data.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoticeDaoImpl implements NoticeDao {

    private final NoticeRepository noticeRepository;

    @Autowired
    public NoticeDaoImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public List<Notice> getAllNotices() {
        List<Notice> notices = noticeRepository.findAll();
        return notices;
    }
    @Override
    public List<Notice> getNoticesbyKeyword(String keyword) {
        List<Notice> notices = noticeRepository.findByKeyword(keyword);
        return notices;
    }

    @Override
    public Notice getRecent() {
        Notice notice = noticeRepository.findTopByOrderByPubDateDesc();
        return notice;
    }
}
