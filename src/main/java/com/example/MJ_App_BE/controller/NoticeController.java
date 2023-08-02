package com.example.MJ_App_BE.controller;


import com.example.MJ_App_BE.Result.CommonResult;
import com.example.MJ_App_BE.Result.ListResult;
import com.example.MJ_App_BE.Result.ResponseService;
import com.example.MJ_App_BE.data.dto.noticedto.NoticeResponseDto;
import com.example.MJ_App_BE.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/notice")
@CrossOrigin(origins = "*")

public class NoticeController {

    private final NoticeService noticeService;
    private final ResponseService responseService;

    @Autowired
    public NoticeController(NoticeService noticeService, ResponseService responseService) {
        this.noticeService = noticeService;
        this.responseService = responseService;
    }

    //카테고리 별 공지 받아오기
    @GetMapping(value = "/{category}")
    public CommonResult getNotices(@PathVariable String category) {
        List<NoticeResponseDto> notices = noticeService.getCategoricalNotices(category);
        ListResult listResult = responseService.getListResult(notices);
        return listResult;
    }

    //전체 공지 중 검색
    @GetMapping(value = "/search")
    public CommonResult getNoticesbyKeyword(@RequestParam("keyword") String keyword) {
        List<NoticeResponseDto> notices = noticeService.getNoticesbyKeyword(keyword);
        ListResult listResult = responseService.getListResult(notices);
        return listResult;
    }

    //카테고리 별 검색
    @GetMapping(value = "/{category}/search")
    public CommonResult getNoticesbyKeyword(@PathVariable String category, @RequestParam("keyword") String keyword) {
        List<NoticeResponseDto> notices = noticeService.getCategoricalNoticesbyKeyword(category, keyword);
        ListResult listResult = responseService.getListResult(notices);
        return listResult;
    }
}
