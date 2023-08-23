package com.example.MJ_App_BE.data.dto.mycreditsdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyCreditsResponseDto {

    private Long myCreditsId;

    private int myTotalCredits;

    private int myCommonElectiveCredits;

    private int myCoreElectiveCredits;

    private int myCollegeElectiveCredits;

    private int myMajorCredits;

    private int myGeneralElectiveCredits;

    private int myFreeCredits;

    private int myChapel;

    private Long myCreditsUserId;
}
