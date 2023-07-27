package com.example.MJ_App_BE.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "user_tag")
@ToString
public class UserTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userTagId;

    @ManyToOne
    @JoinColumn(name = "user_tag_user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_tag_tag_id")
    private Tag tag;

}