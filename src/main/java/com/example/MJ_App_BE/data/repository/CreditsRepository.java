package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.Credits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditsRepository extends JpaRepository<Credits, Long> {
    Credits findByMajorMajorId(Long majorId);
}
