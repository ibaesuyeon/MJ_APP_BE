package com.example.MJ_App_BE.service.impl;

import com.example.MJ_App_BE.data.dao.UserDao;
import com.example.MJ_App_BE.data.dao.UserTagDao;
import com.example.MJ_App_BE.data.dto.tagdto.TagDto;
import com.example.MJ_App_BE.data.dto.tagdto.TagResponseDto;
import com.example.MJ_App_BE.data.dto.usertagdto.UserTagDto;
import com.example.MJ_App_BE.service.UserTagService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserTagServiceImpl implements UserTagService {

    private final UserTagDao userTagDao;

    @Autowired
    public UserTagServiceImpl(UserTagDao userTagDao) {
        this.userTagDao = userTagDao;
    }

    @Override
    public void saveUserTags(UserTagDto userTagDto) {
        Long userId = userTagDto.getUserId();
        List<Long> tagIds = userTagDto.getTagIds();

        userTagDao.saveUserTags(userId, tagIds);
    }

    @Override
    @Transactional
    public void updateUserTags(UserTagDto userTagDto) {
        Long userId = userTagDto.getUserId();
        List<Long> tagIds = userTagDto.getTagIds();

        userTagDao.deleteUserTags(userId);
        userTagDao.saveUserTags(userId, tagIds);
    }

    @Override
    public void deleteUserTags(Long userId) {
        userTagDao.deleteUserTags(userId);
    }

    @Override
    public TagResponseDto getUserTags(Long userId) {
        List<TagDto> tagDto = userTagDao.getUserTags(userId);

        TagResponseDto tagResponseDto = new TagResponseDto();
        tagResponseDto.setTagDtoList(tagDto);

        return tagResponseDto;
    }
}
