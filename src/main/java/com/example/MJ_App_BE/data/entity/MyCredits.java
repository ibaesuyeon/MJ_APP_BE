package com.example.MJ_App_BE.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class MyCredits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myCreditsId;

    @Column(nullable = false)
    private int myTotalCredits;

    @Column(nullable = false)
    private int myCommonElectiveCredits;

    @Column(nullable = false)
    private int myCoreElectiveCredits;

    @Column(nullable = false)
    private int myCollegeElectiveCredits;

    @Column(nullable = false)
    private int myMajorCredits;

    @Column(nullable = false)
    private int myGeneralElectiveCredits;

    @Column(nullable = false)
    private int myFreeCredits;

    @Column(nullable = false)
    private int myMinorCredits;

    @Column(nullable = false)
    private int myDoubleMajorCredits;

    @Column(nullable = false)
    private int myLinkedMajorCredits;

    @Column(nullable = false)
    private int myTeachingCredits;

    @Column(nullable = false)
    private int myChapel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "my_credits_user_id")
    private User user;
}
