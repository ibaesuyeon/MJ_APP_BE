package com.example.MJ_App_BE.controller;

import com.example.MJ_App_BE.Result.CommonResult;
import com.example.MJ_App_BE.Result.ListResult;
import com.example.MJ_App_BE.Result.ResponseService;
import com.example.MJ_App_BE.data.dto.tagdto.TagDto;
import com.example.MJ_App_BE.data.dto.usertagdto.UserTagDto;
import com.example.MJ_App_BE.service.UserTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/user/tag")
@CrossOrigin(origins = "*")

public class UserTagController {

    private final UserTagService userTagService;
    private final ResponseService responseService;

    @Autowired
    public UserTagController(UserTagService userTagService, ResponseService responseService) {
        this.userTagService = userTagService;
        this.responseService = responseService;

    }

    // 사용자가 선택한 태그 저장
    @PostMapping("/register")
    public CommonResult saveTags(@RequestBody UserTagDto userTagDto) {
        userTagService.saveUserTags(userTagDto);
        return responseService.getSuccessfulResult();
    }

    // 태그 수정
    @PutMapping("/modify")
    public CommonResult updateTags(@RequestBody UserTagDto userTagDto) {
        userTagService.updateUserTags(userTagDto);
        return responseService.getSuccessfulResult();
    }

    // 사용자가 저장한 태그 일괄 삭제
    @DeleteMapping("/deletion/{userId}")
    public CommonResult deleteTags(@PathVariable Long userId) {
        userTagService.deleteUserTags(userId);
        return responseService.getSuccessfulResult();
    }

    // 태그 불러오기
    @GetMapping("/{userId}")
    public ListResult<TagDto> getTags(@PathVariable Long userId) {
        List<TagDto> tags = userTagService.getUserTags(userId).getTags();
        return responseService.getListResult(tags);
    }
}
