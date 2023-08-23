package com.example.MJ_App_BE.controller;

import com.example.MJ_App_BE.Result.CommonResult;
import com.example.MJ_App_BE.Result.ListResult;
import com.example.MJ_App_BE.Result.ResponseService;
import com.example.MJ_App_BE.data.dto.keyworddto.KeywordDto;
import com.example.MJ_App_BE.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/user/keyword")
@CrossOrigin(origins = "*")

public class KeywordController {

    private final KeywordService keywordService;
    private final ResponseService responseService;

    @Autowired
    public KeywordController(KeywordService keywordService, ResponseService responseService) {
        this.keywordService = keywordService;
        this.responseService = responseService;
    }

    // 키워드 생성
    @PostMapping("/register")
    public CommonResult saveKeyword(@RequestBody KeywordDto keywordDto) {
        keywordService.saveKeyword(keywordDto);
        return responseService.getSuccessfulResult();
    }

    // 키워드 수정(개별 삭제-저장하면 필요없을 듯?)
    // 키워드 삭제 - 개별 삭제
    @DeleteMapping("/deletion/{keywordId}")
    public CommonResult deleteKeyword(@PathVariable Long keywordId) {
        keywordService.deleteKeyword(keywordId);
        return responseService.getSuccessfulResult();
    }

    // 키워드 리스트로 조회
    @GetMapping("/{userId}")
    public ListResult<KeywordDto> getKeywords(@PathVariable Long userId) {
        List<KeywordDto> keywords = keywordService.getKeywords(userId).getKeywordDtoList();
        return responseService.getListResult(keywords);
    }
}
