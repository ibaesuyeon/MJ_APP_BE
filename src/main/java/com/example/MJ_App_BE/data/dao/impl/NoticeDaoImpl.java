package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.NoticeDao;
import com.example.MJ_App_BE.data.dao.UserDao;
import com.example.MJ_App_BE.data.entity.*;
import com.example.MJ_App_BE.data.repository.*;
import com.example.MJ_App_BE.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.example.MJ_App_BE.exception.ErrorCode.USER_NOT_FOUND;

@Component
public class NoticeDaoImpl implements NoticeDao {

    private final NoticeRepository noticeRepository;

    @Autowired
    public NoticeDaoImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public List<Notice> getCategoricalNotices(String category) {
        List<Notice> notices = noticeRepository.findByCategory(category);
        return notices;
    }

    @Override
    public List<Notice> getNoticesbyKeyword(String keyword) {
        List<Notice> notices = noticeRepository.findAllByKeyword(keyword);
        return notices;
    }

    @Override
    public List<Notice> getCategoricalNoticesbyKeyword(String category, String keyword) {
        List<Notice> notices = noticeRepository.findByCategoryAndKeyword(category, keyword);
        return notices;    }
}
