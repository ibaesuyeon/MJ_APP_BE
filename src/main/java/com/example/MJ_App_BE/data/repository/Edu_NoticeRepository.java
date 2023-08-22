package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.Edu_Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Edu_NoticeRepository extends JpaRepository<Edu_Notice, String> {

    @Query("SELECT n FROM Edu_Notice n")
    List<Edu_Notice> findAll();
    @Query("SELECT n FROM Edu_Notice n WHERE n.title LIKE %:keyword%")
    List<Edu_Notice> findByKeyword(@Param("keyword") String keyword);
    Edu_Notice findTopByOrderByPubDateDesc();


}
