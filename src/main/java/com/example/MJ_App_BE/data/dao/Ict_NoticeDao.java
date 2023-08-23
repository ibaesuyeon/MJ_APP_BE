package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.entity.Ict_Notice;

import java.util.List;

public interface Ict_NoticeDao {
    List<Ict_Notice> getAllNotices();
    List<Ict_Notice> getNoticesbyKeyword(String keyword);
    Ict_Notice getRecent();
}
