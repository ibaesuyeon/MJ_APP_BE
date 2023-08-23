package com.example.MJ_App_BE.service;

import com.example.MJ_App_BE.data.dto.tagdto.TagResponseDto;
import com.example.MJ_App_BE.data.dto.usertagdto.UserTagDto;


public interface UserTagService {

    void saveUserTags(UserTagDto userTagDto);
    void updateUserTags(UserTagDto userTagDto);
    void deleteUserTags(Long userId);
    TagResponseDto getUserTags(Long userId);
}
