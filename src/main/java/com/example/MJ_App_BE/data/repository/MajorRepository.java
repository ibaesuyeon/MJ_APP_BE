package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, Long> {
}
