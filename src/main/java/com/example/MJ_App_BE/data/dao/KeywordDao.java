package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.dto.keyworddto.KeywordDto;

import java.util.List;

public interface KeywordDao {

    void saveKeyword(Long userId, String kname);
    // changeKeywords();
    void deleteKeyword(Long keywordId);
    List<KeywordDto> getKeywords(Long userId);

}
