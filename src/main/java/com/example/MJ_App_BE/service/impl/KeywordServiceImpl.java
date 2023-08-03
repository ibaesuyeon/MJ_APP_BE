package com.example.MJ_App_BE.service.impl;

import com.example.MJ_App_BE.data.dao.KeywordDao;
import com.example.MJ_App_BE.data.dto.keyworddto.KeywordDto;
import com.example.MJ_App_BE.data.dto.keyworddto.KeywordResponseDto;
import com.example.MJ_App_BE.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordServiceImpl implements KeywordService {

    private final KeywordDao keywordDao;

    @Autowired
    public KeywordServiceImpl(KeywordDao keywordDao) {
        this.keywordDao = keywordDao;
    }

    @Override
    public void saveKeyword(KeywordDto keywordDto) {
        Long userId = keywordDto.getUserId();
        String kname = keywordDto.getKname();

        keywordDao.saveKeyword(userId, kname);
    }
    // KeywordResponseDto changeKeyword();
    @Override
    public void deleteKeyword(Long keywordId) {
        keywordDao.deleteKeyword(keywordId);
    }
    @Override
    public KeywordResponseDto getKeywords(Long userId) {
        List<KeywordDto> keywordDtos = keywordDao.getKeywords(userId);

        KeywordResponseDto keywordResponseDto = new KeywordResponseDto();
        keywordResponseDto.setKeywordDtoList(keywordDtos);

        return keywordResponseDto;
    }

}
