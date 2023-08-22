package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.entity.Work_Notice;

import java.util.List;

public interface Work_NoticeDao {
    List<Work_Notice> getAllNotices();
    List<Work_Notice> getNoticesbyKeyword(String keyword);

    Work_Notice getRecent();
}
