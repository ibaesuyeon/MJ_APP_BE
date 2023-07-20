package com.example.MJ_App_BE.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collegeId;

    @Column(nullable = false)
    private String collegeName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "college_campus_id")
    private Campus campus;

    @OneToMany(mappedBy = "college")
    private List<Major> majorList = new ArrayList<>();

    @OneToMany(mappedBy = "college")
    private List<CNotice> cNoticeList = new ArrayList<>();

    @OneToMany(mappedBy = "college")
    private List<Course> courseList = new ArrayList<>();

    @OneToMany(mappedBy = "college")
    private List<User> userList = new ArrayList<>();
}
