package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.MyCredits;
import com.example.MJ_App_BE.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyCreditsRepository extends JpaRepository<MyCredits, Long> {
    Optional<MyCredits> findByUser(User user);
}
