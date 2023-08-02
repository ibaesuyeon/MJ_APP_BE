package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.entity.Notice;

import java.util.List;

public interface NoticeDao {
    List<Notice> getNotices(String category);
}
