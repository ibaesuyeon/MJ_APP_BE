package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.entity.Law_Notice;

import java.util.List;

public interface Law_NoticeDao {
    List<Law_Notice> getAllNotices();
    List<Law_Notice> getNoticesbyKeyword(String keyword);
    Law_Notice getRecent();
}
