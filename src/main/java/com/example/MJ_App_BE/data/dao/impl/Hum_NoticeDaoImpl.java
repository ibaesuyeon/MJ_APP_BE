package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.Hum_NoticeDao;
import com.example.MJ_App_BE.data.entity.Hum_Notice;
import com.example.MJ_App_BE.data.repository.Hum_NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Hum_NoticeDaoImpl implements Hum_NoticeDao {

    private final Hum_NoticeRepository hum_noticeRepository;

    @Autowired
    public Hum_NoticeDaoImpl(Hum_NoticeRepository hum_noticeRepository) {
        this.hum_noticeRepository = hum_noticeRepository;
    }

    @Override
    public List<Hum_Notice> getAllNotices() {
        List<Hum_Notice> notices = hum_noticeRepository.findAll();
        return notices;
    }
    @Override
    public List<Hum_Notice> getNoticesbyKeyword(String keyword) {
        List<Hum_Notice> notices = hum_noticeRepository.findByKeyword(keyword);
        return notices;
    }

    @Override
    public Hum_Notice getRecent() {
        Hum_Notice notice = hum_noticeRepository.findTopByOrderByPubDateDesc();
        return notice;
    }
}
