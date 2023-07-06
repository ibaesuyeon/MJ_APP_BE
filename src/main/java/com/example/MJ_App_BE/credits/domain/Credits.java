package com.example.MJ_App_BE.credits.domain;

import com.example.MJ_App_BE.major.Major;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Credits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    private int minorCredits;

    private int doubleMajorCredits;

    private int linkedMajorCredits;

    private int teachingCredits;

    @Column(nullable = false)
    private int chapel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "credits_major_id")
    private Major major;

}
