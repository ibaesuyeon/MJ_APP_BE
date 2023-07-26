package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.Credits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CreditsRepository extends JpaRepository<Credits, Long> {

    Credits findByMajorMajorId(Long majorId);

    @Query("SELECT u FROM Credits u WHERE u.creditsMajorId = :creditsMajorId")
    Credits findByCreditsMajorId(@Param("creditsMajorId") Long creditsMajorId);

}
