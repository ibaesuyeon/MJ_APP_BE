package com.example.MJ_App_BE.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
@Table(name = "c_notice")
public class CNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cNoticeId;

    @Column(nullable = false, unique = true)
    private int cNum;

    @Column(nullable = false)
    private String cCategory;

    @Column(nullable = false)
    private String cTitle;

    @Column(nullable = false)
    private String cPubDate;

    @Column(nullable = false)
    private String cLink;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "c_notice_college_id")
    private College college;
}
