package com.example.MJ_App_BE.mnotice.domain;

import com.example.MJ_App_BE.univ.Univ;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
@Table(name = "m_notice")
public class MNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int mNoticeNo;

    @Column(nullable = false)
    private String mCategory;

    @Column(nullable = false)
    private String mTitle;

    @Column(nullable = false)
    private String mAuthor;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date mCreationDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date mRevisionDate;

    private String mContents;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "m_notice_univ_id")
    private Univ univ;
}
