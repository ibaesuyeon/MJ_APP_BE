package com.example.MJ_App_BE.controller;


import com.example.MJ_App_BE.data.dto.creditsdto.CreditsDto;
import com.example.MJ_App_BE.service.CreditsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/credits")
@RequiredArgsConstructor
public class CreditsController {

    private final CreditsService creditsService;

    @PostMapping
    public CreditsDto getCreditsByMajorId(@RequestBody Map<String, Long> requestBody) {
        Long userId = requestBody.get("userId");
        return creditsService.getCreditsByMajorId(userId);
    }

}
