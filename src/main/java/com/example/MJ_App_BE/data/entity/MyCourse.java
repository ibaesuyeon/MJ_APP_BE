package com.example.MJ_App_BE.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MyCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myCourseId;

    @Column(nullable = false)
    private String cname;

    @Column(nullable = false)
    private int credit;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Semester semester;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Ctype ctype;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "my_course_user_id")
    private User user;

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
