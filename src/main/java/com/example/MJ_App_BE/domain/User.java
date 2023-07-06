package com.example.MJ_App_BE.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String deviceId;

    @Column(nullable = false)
    private int year;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_univ_id")
    private Univ univ;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_campus_id")
    private Campus campus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_college_id")
    private College college;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_major_id")
    private Major major;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MyCredits> myCreditsList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MyCourse> myCourseList = new ArrayList<>();

    @Builder
    public User(String deviceId, int year, Univ univ, Campus campus, College college, Major major) {
        this.deviceId = deviceId;
        this.year = year;
        this.univ = univ;
        this.campus = campus;
        this.college = college;
        this.major = major;
    }
}
