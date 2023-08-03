package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.KeywordDao;
import com.example.MJ_App_BE.data.dto.keyworddto.KeywordDto;
import com.example.MJ_App_BE.data.entity.Keyword;
import com.example.MJ_App_BE.data.entity.User;
import com.example.MJ_App_BE.data.repository.KeywordRepository;
import com.example.MJ_App_BE.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KeywordDaoImpl implements KeywordDao {

    private final UserRepository userRepository;
    private final KeywordRepository keywordRepository;

    @Autowired
    public KeywordDaoImpl(UserRepository userRepository, KeywordRepository keywordRepository) {
        this.userRepository = userRepository;
        this.keywordRepository = keywordRepository;
    }

    // 키워드 생성 - 개별 저장
    @Override
    public void saveKeyword(Long userId, String kname) {
        User user = userRepository.findByUserId(userId);

        Keyword keyword = new Keyword();
        keyword.setUser(user);
        keyword.setKname(kname);

        keywordRepository.save(keyword);
    }

    // 키워드 수정?
    // 키워드 삭제 - 태그랑 다르게 개별 삭제
    @Override
    public void deleteKeyword(Long keywordId) {
        keywordRepository.deleteById(keywordId);
    }

    // 키워드 리스트로 조회
    @Override
    public List<KeywordDto> getKeywords(Long userId) {
        User user = userRepository.findByUserId(userId);
        List<KeywordDto> keywordDtoList = new ArrayList<>();

        for (Keyword keyword : user.getKeywordList()) {
            KeywordDto keywordDto = new KeywordDto();
            keywordDto.setKeywordId(keyword.getKeywordId());
            keywordDto.setUserId(userId);
            keywordDto.setKname(keyword.getKname());

            keywordDtoList.add(keywordDto);
        }
        return keywordDtoList;
    }
}
