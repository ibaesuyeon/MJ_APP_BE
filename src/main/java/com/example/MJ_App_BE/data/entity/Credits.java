package com.example.MJ_App_BE.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
@Table(name = "credits")
@ToString
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

    private int minorCredits;

    private int doubleMajorCredits;

    private int linkedMajorCredits;

    private int teachingCredits;

    @Column(nullable = false)
    private int chapel;

    @Column(nullable = false)
    private Long creditsMajorId;


}
