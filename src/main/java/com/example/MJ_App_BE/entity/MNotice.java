package com.example.MJ_App_BE.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
@Table(name = "m_notice")
public class MNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mNoticeId;

    @Column(nullable = false, unique = true)
    private int mNum;

    @Column(nullable = false)
    private String mCategory;

    @Column(nullable = false)
    private String mTitle;

    @Column(nullable = false)
    private String mPubDate;

    @Column(nullable = false)
    private String mLink;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "m_notice_univ_id")
    private Univ univ;
}
