package com.example.MJ_App_BE.data.dto.noticedto;

import com.example.MJ_App_BE.data.entity.Credits;
import com.example.MJ_App_BE.data.entity.Notice;
import com.example.MJ_App_BE.data.entity.Univ;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
public class NoticeDto {

    private Long noticeId;
    private int num;
    private String category;
    private String title;
    private String pubDate;
    private String link;
//    private Univ univ;

}
