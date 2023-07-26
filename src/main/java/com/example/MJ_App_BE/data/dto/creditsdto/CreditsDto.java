package com.example.MJ_App_BE.data.dto.creditsdto;

import lombok.*;

@Data
@NoArgsConstructor@AllArgsConstructor
@ToString@Builder
public class CreditsDto {
    private int totalCredits;
    private int commonElectiveCredits;
    private int coreElectiveCredits;
    private int collegeElectiveCredits;
    private int majorCredits;
    private int generalElectiveCredits;
    private int freeCredits;
    private int chapel;
    private Long creditsMajorId;
}
