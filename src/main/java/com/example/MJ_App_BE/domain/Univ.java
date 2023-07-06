package com.example.MJ_App_BE.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Univ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long univId;

    @Column(nullable = false, unique = true)
    private String univName;

    @OneToMany(mappedBy = "univ")
    private List<User> userList = new ArrayList<>();

    @OneToMany(mappedBy = "univ", cascade = CascadeType.ALL)
    private List<Notice> noticeList = new ArrayList<>();

    @OneToMany(mappedBy = "univ", cascade = CascadeType.ALL)
    private List<MNotice> mNoticeList = new ArrayList<>();

    @OneToMany(mappedBy = "univ", cascade = CascadeType.ALL)
    private List<Campus> campusList = new ArrayList<>();

}
