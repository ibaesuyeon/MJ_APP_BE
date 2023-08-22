package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.Festival_Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Festival_NoticeRepository extends JpaRepository<Festival_Notice, String> {

    @Query("SELECT n FROM Festival_Notice n")
    List<Festival_Notice> findAll();
    @Query("SELECT n FROM Festival_Notice n WHERE n.title LIKE %:keyword%")
    List<Festival_Notice> findByKeyword(@Param("keyword") String keyword);
    Festival_Notice findTopByOrderByPubDateDesc();


}
