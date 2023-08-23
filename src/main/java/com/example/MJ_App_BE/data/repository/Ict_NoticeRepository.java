package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.Ict_Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Ict_NoticeRepository extends JpaRepository<Ict_Notice, String> {

    @Query("SELECT n FROM Ict_Notice n")
    List<Ict_Notice> findAll();
    @Query("SELECT n FROM Ict_Notice n WHERE n.title LIKE %:keyword%")
    List<Ict_Notice> findByKeyword(@Param("keyword") String keyword);
    Ict_Notice findTopByOrderByPubDateDesc();


}
