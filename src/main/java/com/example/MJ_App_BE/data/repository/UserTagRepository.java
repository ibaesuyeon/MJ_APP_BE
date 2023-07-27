package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.UserTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTagRepository extends JpaRepository<UserTag, Long> {
}
