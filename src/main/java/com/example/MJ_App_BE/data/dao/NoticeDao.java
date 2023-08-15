package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.entity.Notice;

import java.util.List;

public interface NoticeDao {
    List<Notice> getCategoricalNotices(String category);
    List<Notice> getNoticesbyKeyword(String keyword);
    List<Notice> getCategoricalNoticesbyKeyword(String category, String keyword);
}