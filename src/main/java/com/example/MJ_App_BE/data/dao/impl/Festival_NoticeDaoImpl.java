package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.Festival_NoticeDao;
import com.example.MJ_App_BE.data.entity.Festival_Notice;
import com.example.MJ_App_BE.data.repository.Festival_NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Festival_NoticeDaoImpl implements Festival_NoticeDao {

    private final Festival_NoticeRepository festival_noticeRepository;

    @Autowired
    public Festival_NoticeDaoImpl(Festival_NoticeRepository festival_noticeRepository) {
        this.festival_noticeRepository = festival_noticeRepository;
    }

    @Override
    public List<Festival_Notice> getAllNotices() {
        List<Festival_Notice> notices = festival_noticeRepository.findAll();
        return notices;
    }
    @Override
    public List<Festival_Notice> getNoticesbyKeyword(String keyword) {
        List<Festival_Notice> notices = festival_noticeRepository.findByKeyword(keyword);
        return notices;
    }

    @Override
    public Festival_Notice getRecent() {
        Festival_Notice notice = festival_noticeRepository.findTopByOrderByPubDateDesc();
        return notice;
    }
}
