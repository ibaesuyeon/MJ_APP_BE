package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.School_Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface School_NoticeRepository extends JpaRepository<School_Notice, String> {

    @Query("SELECT n FROM School_Notice n")
    List<School_Notice> findAll();
    @Query("SELECT n FROM School_Notice n WHERE n.title LIKE %:keyword%")
    List<School_Notice> findByKeyword(@Param("keyword") String keyword);
    School_Notice findTopByOrderByPubDateDesc();


}
