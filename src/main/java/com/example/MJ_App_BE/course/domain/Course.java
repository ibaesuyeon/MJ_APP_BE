package com.example.MJ_App_BE.course.domain;

import com.example.MJ_App_BE.college.College;
import com.example.MJ_App_BE.major.Major;
import com.example.MJ_App_BE.mycourse.domain.MyCourse;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cname;

    @Column(nullable = false)
    private int credit;

    @Column(nullable = false)
    private String ctype;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_college_id")
    private College college;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_major_id")
    private Major major;

    @OneToMany(mappedBy = "course")
    private List<MyCourse> myCourseList = new ArrayList<>();

}
