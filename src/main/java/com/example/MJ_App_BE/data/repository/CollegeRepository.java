package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College, Long> {
}
