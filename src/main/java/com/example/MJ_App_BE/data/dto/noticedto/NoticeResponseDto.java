package com.example.MJ_App_BE.data.dto.noticedto;

import com.example.MJ_App_BE.data.entity.Univ;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class NoticeResponseDto {
    private Long noticeId;
    private int num;
    private String category;
    private String title;
    private String pubDate;
    private String link;
//    private Univ univ;


    public NoticeResponseDto(){}

}