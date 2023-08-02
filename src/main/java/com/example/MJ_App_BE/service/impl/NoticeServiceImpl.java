package com.example.MJ_App_BE.service.impl;
import com.example.MJ_App_BE.data.dao.NoticeDao;
import com.example.MJ_App_BE.data.dto.noticedto.NoticeResponseDto;
import com.example.MJ_App_BE.data.entity.*;
import com.example.MJ_App_BE.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeDao noticeDao;

    @Autowired
    public NoticeServiceImpl(NoticeDao noticeDao){
        this.noticeDao = noticeDao;
    }

    @Override
    public List<NoticeResponseDto> getNotices(String category) {
        List<Notice> notices = noticeDao.getNotices(category);
        List<NoticeResponseDto> noticeResponseDtos = new ArrayList<NoticeResponseDto>();

        for(int i=0;i<notices.size();i++) {
            NoticeResponseDto noticeResponseDto = new NoticeResponseDto();

            noticeResponseDto.setNoticeId(notices.get(i).getNoticeId());
            noticeResponseDto.setNum(notices.get(i).getNum());
            noticeResponseDto.setCategory(notices.get(i).getCategory());
            noticeResponseDto.setTitle(notices.get(i).getTitle());
            noticeResponseDto.setPubDate(notices.get(i).getPubDate());
            noticeResponseDto.setLink(notices.get(i).getLink());
//            noticeResponseDto.setUniv(notices.get(i).getUniv());

            noticeResponseDtos.add(noticeResponseDto);
        }
        return noticeResponseDtos;
    }

    @Override
    public List<NoticeResponseDto> getNoticesbyKeyword(String keyword) {
        List<Notice> notices = noticeDao.getNoticesbyKeyword(keyword);
        List<NoticeResponseDto> noticeResponseDtos = new ArrayList<NoticeResponseDto>();

        for(int i=0;i<notices.size();i++) {
            NoticeResponseDto noticeResponseDto = new NoticeResponseDto();

            noticeResponseDto.setNoticeId(notices.get(i).getNoticeId());
            noticeResponseDto.setNum(notices.get(i).getNum());
            noticeResponseDto.setCategory(notices.get(i).getCategory());
            noticeResponseDto.setTitle(notices.get(i).getTitle());
            noticeResponseDto.setPubDate(notices.get(i).getPubDate());
            noticeResponseDto.setLink(notices.get(i).getLink());
//            noticeResponseDto.setUniv(notices.get(i).getUniv());

            noticeResponseDtos.add(noticeResponseDto);
        }
        return noticeResponseDtos;    }
}
