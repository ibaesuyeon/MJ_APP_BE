package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.St_Work_NoticeDao;
import com.example.MJ_App_BE.data.entity.St_Work_Notice;
import com.example.MJ_App_BE.data.repository.St_Work_NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class St_Work_NoticeDaoImpl implements St_Work_NoticeDao {

    private final St_Work_NoticeRepository st_work_noticeRepository;

    @Autowired
    public St_Work_NoticeDaoImpl(St_Work_NoticeRepository st_work_noticeRepository) {
        this.st_work_noticeRepository = st_work_noticeRepository;
    }

    @Override
    public List<St_Work_Notice> getAllNotices() {
        List<St_Work_Notice> notices = st_work_noticeRepository.findAll();
        return notices;
    }
    @Override
    public List<St_Work_Notice> getNoticesbyKeyword(String keyword) {
        List<St_Work_Notice> notices = st_work_noticeRepository.findByKeyword(keyword);
        return notices;
    }

    @Override
    public St_Work_Notice getRecent() {
        St_Work_Notice notice = st_work_noticeRepository.findTopByOrderByPubDateDesc();
        return notice;
    }
}
