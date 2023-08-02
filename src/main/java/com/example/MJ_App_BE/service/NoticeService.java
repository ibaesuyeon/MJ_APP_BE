package com.example.MJ_App_BE.service;

import com.example.MJ_App_BE.data.dto.noticedto.NoticeResponseDto;

import java.util.List;

public interface NoticeService {

    List<NoticeResponseDto> getNotices(String category);

}
