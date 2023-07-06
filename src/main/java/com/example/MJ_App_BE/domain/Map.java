package com.example.MJ_App_BE.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String building;

    private String floor;

    private String classNo;

    private String className;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "map_campus_id")
    private Campus campus;
}
