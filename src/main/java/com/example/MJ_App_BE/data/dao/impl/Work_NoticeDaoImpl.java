package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.Work_NoticeDao;
import com.example.MJ_App_BE.data.entity.Work_Notice;
import com.example.MJ_App_BE.data.repository.Work_NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Work_NoticeDaoImpl implements Work_NoticeDao {

    private final Work_NoticeRepository work_noticeRepository;

    @Autowired
    public Work_NoticeDaoImpl(Work_NoticeRepository work_noticeRepository) {
        this.work_noticeRepository = work_noticeRepository;
    }

    @Override
    public List<Work_Notice> getAllNotices() {
        List<Work_Notice> notices = work_noticeRepository.findAll();
        return notices;
    }
    @Override
    public List<Work_Notice> getNoticesbyKeyword(String keyword) {
        List<Work_Notice> notices = work_noticeRepository.findByKeyword(keyword);
        return notices;
    }

    @Override
    public Work_Notice getRecent() {
        Work_Notice notice = work_noticeRepository.findTopByOrderByPubDateDesc();
        return notice;
    }
}
