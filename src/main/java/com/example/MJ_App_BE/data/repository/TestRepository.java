package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Integer> {
}
