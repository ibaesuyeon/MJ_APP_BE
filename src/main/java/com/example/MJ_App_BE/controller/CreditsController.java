package com.example.MJ_App_BE.controller;


import com.example.MJ_App_BE.Result.CommonResult;
import com.example.MJ_App_BE.Result.ResponseService;
import com.example.MJ_App_BE.data.dto.creditsdto.CreditsDto;
import com.example.MJ_App_BE.data.dto.creditsdto.CreditsResponseDto;
import com.example.MJ_App_BE.service.CreditsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

@RequestMapping("/credits")
@CrossOrigin(origins = "*")

public class CreditsController {

    private final CreditsService creditsService;
    private final ResponseService responseService;

    @Autowired
    public CreditsController(CreditsService creditsService, ResponseService responseService) {
        this.creditsService = creditsService;
        this.responseService = responseService;
    }

    //졸업학점 정보 가져오기
    @GetMapping(value = "/get/{creditsMajorId}")
    public CommonResult getCredits(@PathVariable Long creditsMajorId) {
        CreditsResponseDto creditsOne = creditsService.getCredits(creditsMajorId);
        CommonResult commonResult = responseService.getSingleResult(creditsOne);
        return commonResult;
    }

    @PostMapping
    public CreditsDto getCreditsByMajorId(@RequestBody Map<String, Long> requestBody) {
        Long userId = requestBody.get("userId");
        return creditsService.getCreditsByMajorId(userId);
    }

}
