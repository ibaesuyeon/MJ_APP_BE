package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.entity.Edu_Notice;

import java.util.List;

public interface Edu_NoticeDao {
    List<Edu_Notice> getAllNotices();
    List<Edu_Notice> getNoticesbyKeyword(String keyword);
    Edu_Notice getRecent();
}
