package com.example.MJ_App_BE.data.dto.creditsdto;

import com.example.MJ_App_BE.data.entity.Credits;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
public class CreditsDto {

    private int totalCredits;

    private int commonElectiveCredits;

    private int coreElectiveCredits;

    private int collegeElectiveCredits;

    private int majorCredits;

    private int generalElectiveCredits;

    private int freeCredits;

    private int chapel;


    public CreditsDto(Credits credits) {
        this.totalCredits = credits.getTotalCredits();
        this.commonElectiveCredits = credits.getCommonElectiveCredits();
        this.coreElectiveCredits = credits.getCoreElectiveCredits();
        this.collegeElectiveCredits = credits.getCollegeElectiveCredits();
        this.majorCredits = credits.getMajorCredits();
        this.generalElectiveCredits = credits.getGeneralElectiveCredits();
        this.freeCredits = credits.getFreeCredits();
        this.chapel = credits.getChapel();
    }
}
