package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.entity.Business_Notice;

import java.util.List;

public interface Business_NoticeDao {
    List<Business_Notice> getAllNotices();
    List<Business_Notice> getNoticesbyKeyword(String keyword);
    Business_Notice getRecent();
}
