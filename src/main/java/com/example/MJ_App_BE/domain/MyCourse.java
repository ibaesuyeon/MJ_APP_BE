package com.example.MJ_App_BE.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class MyCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myCourseId;

    private String details;

    private String grade;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)    // enum 타입?
    private String semester;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "my_course_course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "my_course_user_id")
    private User user;
}
