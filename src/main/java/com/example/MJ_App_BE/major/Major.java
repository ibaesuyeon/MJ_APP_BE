package com.example.MJ_App_BE.major;

import com.example.MJ_App_BE.college.College;
import com.example.MJ_App_BE.course.domain.Course;
import com.example.MJ_App_BE.credits.domain.Credits;
import com.example.MJ_App_BE.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
