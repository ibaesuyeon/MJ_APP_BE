package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.Business_Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Business_NoticeRepository extends JpaRepository<Business_Notice, String> {

    @Query("SELECT n FROM Business_Notice n")
    List<Business_Notice> findAll();
    @Query("SELECT n FROM Business_Notice n WHERE n.title LIKE %:keyword%")
    List<Business_Notice> findByKeyword(@Param("keyword") String keyword);
    Business_Notice findTopByOrderByPubDateDesc();


}
