package com.example.MJ_App_BE.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Ict_Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    @Column(nullable = false, unique = true)
    private int num;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String pubDate;

    @Column(nullable = false)
    private String link;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "notice_univ_id")
    private Univ univ;
}
