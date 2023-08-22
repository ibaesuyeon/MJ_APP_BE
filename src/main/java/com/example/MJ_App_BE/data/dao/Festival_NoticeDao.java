package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.entity.Festival_Notice;

import java.util.List;

public interface Festival_NoticeDao {
    List<Festival_Notice> getAllNotices();
    List<Festival_Notice> getNoticesbyKeyword(String keyword);

    Festival_Notice getRecent();
}
