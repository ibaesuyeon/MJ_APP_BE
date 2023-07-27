package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.dto.tagdto.TagDto;
import com.example.MJ_App_BE.data.entity.UserTag;

import java.util.List;

public interface UserTagDao {

    void saveUserTags(Long userId, List<Long> tagIds);
    void deleteUserTags(Long userId);
    List<TagDto> getUserTags(Long userId);
}
