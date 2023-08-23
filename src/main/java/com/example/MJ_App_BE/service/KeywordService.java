package com.example.MJ_App_BE.service;

import com.example.MJ_App_BE.data.dto.keyworddto.KeywordDto;
import com.example.MJ_App_BE.data.dto.keyworddto.KeywordResponseDto;

public interface KeywordService {

    void saveKeyword(KeywordDto keywordDto);
    // KeywordResponseDto changeKeyword();
    void deleteKeyword(Long keywordId);
    KeywordResponseDto getKeywords(Long userId);
}
