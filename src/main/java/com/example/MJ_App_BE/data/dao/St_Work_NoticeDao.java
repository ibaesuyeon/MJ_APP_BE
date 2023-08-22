package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.entity.St_Work_Notice;

import java.util.List;

public interface St_Work_NoticeDao {
    List<St_Work_Notice> getAllNotices();
    List<St_Work_Notice> getNoticesbyKeyword(String keyword);

    St_Work_Notice getRecent();
}
