package com.example.MJ_App_BE.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campusId;

    @Column(nullable = false)
    private String campusName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "campus_univ_id")
    private Univ univ;

    @OneToMany(mappedBy = "campus")
    private List<Menu> menuList = new ArrayList<>();

    @OneToMany(mappedBy = "campus")
    private List<Map> mapList = new ArrayList<>();

}
