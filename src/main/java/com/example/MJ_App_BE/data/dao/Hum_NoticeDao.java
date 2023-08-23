package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.entity.Hum_Notice;

import java.util.List;

public interface Hum_NoticeDao {
    List<Hum_Notice> getAllNotices();
    List<Hum_Notice> getNoticesbyKeyword(String keyword);
    Hum_Notice getRecent();
}
