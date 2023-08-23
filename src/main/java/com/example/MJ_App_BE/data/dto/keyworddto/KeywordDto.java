package com.example.MJ_App_BE.data.dto.keyworddto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class KeywordDto {

    private Long keywordId;
    private Long userId;
    private String kname;
}
