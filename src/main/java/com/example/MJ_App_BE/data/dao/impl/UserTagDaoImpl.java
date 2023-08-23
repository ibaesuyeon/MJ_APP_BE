package com.example.MJ_App_BE.data.dao.impl;

import com.example.MJ_App_BE.data.dao.UserTagDao;
import com.example.MJ_App_BE.data.dto.tagdto.TagDto;
import com.example.MJ_App_BE.data.entity.Tag;
import com.example.MJ_App_BE.data.entity.User;
import com.example.MJ_App_BE.data.entity.UserTag;
import com.example.MJ_App_BE.data.repository.TagRepository;
import com.example.MJ_App_BE.data.repository.UserRepository;
import com.example.MJ_App_BE.data.repository.UserTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserTagDaoImpl implements UserTagDao {

    private final UserTagRepository userTagRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;

    @Autowired
    public UserTagDaoImpl(UserTagRepository userTagRepository, UserRepository userRepository,
                          TagRepository tagRepository) {
        this.userTagRepository = userTagRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public void saveUserTags(Long userId, List<Long> tagIds) {
        User user = userRepository.findByUserId(userId);

        for (Long tagId : tagIds) {
            Tag tag = tagRepository.getReferenceById(tagId);
            UserTag userTag = new UserTag();
            userTag.setUser(user);
            userTag.setTag(tag);

            userTagRepository.save(userTag);   // 개별로 저장
        }
    }

    @Override
    public void deleteUserTags(Long userId) {
        User user = userRepository.findByUserId(userId);
        userTagRepository.deleteAll(user.getUserTags());
    }


    @Override
    public List<TagDto> getUserTags(Long userId) {
        User user = userRepository.findByUserId(userId);

        List<TagDto> tagDtoList = new ArrayList<>();

        for (UserTag userTag : user.getUserTags()) {
            Tag tag = userTag.getTag();
            TagDto tagDto = new TagDto();
            tagDto.setTagId(tag.getTagId());
            tagDto.setTname(tag.getTname());
            tagDtoList.add(tagDto);
        }
        return tagDtoList;
    }

}
