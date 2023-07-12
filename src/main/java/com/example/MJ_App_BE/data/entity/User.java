package com.example.MJ_App_BE.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
@Table(name = "user")
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false)
    private String deviceId;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int userCampusId;

    @Column(nullable = false)
    private int userCollegeId;

    @Column(nullable = false)
    private int userMajorId;

    @Column(nullable = false)
    private int userUnivId;


}
