package com.example.MJ_App_BE.notice.domain;

import com.example.MJ_App_BE.univ.Univ;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int noticeNo;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date revisionDate;

    private String contents;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "notice_univ_id")
    private Univ univ;
}
