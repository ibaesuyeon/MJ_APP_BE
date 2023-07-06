package com.example.MJ_App_BE.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long majorId;

    @Column(nullable = false)
    private String majorName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "major_college_id")
    private College college;

    @OneToMany(mappedBy = "major")
    private List<Course> courseList = new ArrayList<>();

    @OneToMany(mappedBy = "major")
    private List<Credits> creditsList = new ArrayList<>();

    @OneToMany(mappedBy = "major")
    private List<User> userList = new ArrayList<>();
}
