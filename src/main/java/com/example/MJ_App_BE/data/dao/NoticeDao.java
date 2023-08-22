package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.entity.Notice;

import java.util.List;

public interface NoticeDao {
    List<Notice> getAllNotices();
    List<Notice> getNoticesbyKeyword(String keyword);
    Notice getRecent();
}
