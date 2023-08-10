package com.example.MJ_App_BE.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class MyCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myCourseId;

    private String details;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Semester semester;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "my_course_course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "my_course_user_id")
    private User user;

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
