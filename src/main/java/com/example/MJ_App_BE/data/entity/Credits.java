package com.example.MJ_App_BE.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Credits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creditsId;

    @Column(nullable = false)
    private int totalCredits;

    @Column(nullable = false)
    private int commonElectiveCredits;

    @Column(nullable = false)
    private int coreElectiveCredits;

    @Column(nullable = false)
    private int collegeElectiveCredits;

    @Column(nullable = false)
    private int majorCredits;

    @Column(nullable = false)
    private int generalElectiveCredits;

    @Column(nullable = false)
    private int freeCredits;

    @Column(nullable = false)
    private int minorCredits;

    @Column(nullable = false)
    private int doubleMajorCredits;

    @Column(nullable = false)
    private int linkedMajorCredits;

    @Column(nullable = false)
    private int teachingCredits;

    @Column(nullable = false)
    private int chapel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "credits_major_id")
    private Major major;

}
