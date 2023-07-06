package com.example.MJ_App_BE.domain;

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
    private int cNoticeNo;

    @Column(nullable = false)
    private String cCategory;

    @Column(nullable = false)
    private String cTitle;

    @Column(nullable = false)
    private String cAuthor;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date cCreationDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date cRevisionDate;

    private String cContents;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "c_notice_college_id")
    private College college;
}
