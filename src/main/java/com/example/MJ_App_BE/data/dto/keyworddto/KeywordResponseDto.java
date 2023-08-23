package com.example.MJ_App_BE.data.dto.keyworddto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KeywordResponseDto {

    private List<KeywordDto> keywordDtoList;
}
