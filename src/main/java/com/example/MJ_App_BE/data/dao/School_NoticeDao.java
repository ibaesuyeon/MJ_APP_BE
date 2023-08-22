package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.entity.School_Notice;

import java.util.List;

public interface School_NoticeDao {
    List<School_Notice> getAllNotices();
    List<School_Notice> getNoticesbyKeyword(String keyword);
    School_Notice getRecent();
}
