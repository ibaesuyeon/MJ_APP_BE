package com.example.MJ_App_BE.data.dto.creditsdto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CreditsResponseDto {
    private Long creditsId;
    private int totalCredits;
    private int commonElectiveCredits;
    private int coreElectiveCredits;
    private int collegeElectiveCredits;
    private int majorCredits;
    private int generalElectiveCredits;
    private int freeCredits;
    private int chapel;
    private Long creditsMajorId;

    public CreditsResponseDto(){}

}