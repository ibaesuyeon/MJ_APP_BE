package com.example.MJ_App_BE.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class MyCredits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myCreditsId;

    @Column(nullable = false)
    private int myTotalCredits = 0;

    @Column(nullable = false)
    private int myCommonElectiveCredits = 0;

    @Column(nullable = false)
    private int myCoreElectiveCredits = 0;

    @Column(nullable = false)
    private int myCollegeElectiveCredits = 0;

    @Column(nullable = false)
    private int myMajorCredits = 0;

    @Column(nullable = false)
    private int myGeneralElectiveCredits = 0;

    @Column(nullable = false)
    private int myFreeCredits = 0;

    @Column(nullable = false)
    private int myMinorCredits = 0;

    @Column(nullable = false)
    private int myDoubleMajorCredits = 0;

    @Column(nullable = false)
    private int myLinkedMajorCredits = 0;

    @Column(nullable = false)
    private int myTeachingCredits = 0;

    @Column(nullable = false)
    private int myChapel = 0;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "my_credits_user_id")
    private User user;

    public void updateMyCredits(MyCredits myCredits) {
        this.myTotalCredits = myCredits.getMyTotalCredits();
        this.myCommonElectiveCredits = myCredits.getMyCommonElectiveCredits();
        this.myCoreElectiveCredits = myCredits.getMyCoreElectiveCredits();
        this.myCollegeElectiveCredits = myCredits.getMyCollegeElectiveCredits();
        this.myGeneralElectiveCredits = myCredits.getMyGeneralElectiveCredits();
        this.myMajorCredits = myCredits.getMyMajorCredits();
        this.myFreeCredits = myCredits.getMyFreeCredits();
        this.myMinorCredits = myCredits.getMyMinorCredits();
        this.myLinkedMajorCredits = myCredits.getMyLinkedMajorCredits();
        this.myDoubleMajorCredits = myCredits.getMyDoubleMajorCredits();
        this.myTeachingCredits = myCredits.getMyTeachingCredits();
        this.myChapel = myCredits.getMyChapel();
    }
}
