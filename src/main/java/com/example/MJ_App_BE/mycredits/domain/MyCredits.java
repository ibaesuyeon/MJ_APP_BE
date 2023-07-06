package com.example.MJ_App_BE.mycredits.domain;

import com.example.MJ_App_BE.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class MyCredits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    private int myMinorCredits;

    private int myDoubleMajorCredits;

    private int myLinkedMajorCredits;

    private int myTeachingCredits;

    @Column(nullable = false)
    private int myChapel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "my_credits_user_id")
    private User user;
}
