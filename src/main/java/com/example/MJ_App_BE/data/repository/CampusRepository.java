package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.Campus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampusRepository extends JpaRepository<Campus, Long> {
}
