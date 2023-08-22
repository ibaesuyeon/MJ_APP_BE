package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.Work_Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Work_NoticeRepository extends JpaRepository<Work_Notice, String> {

    @Query("SELECT n FROM Work_Notice n")
    List<Work_Notice> findAll();
    @Query("SELECT n FROM Work_Notice n WHERE n.title LIKE %:keyword%")
    List<Work_Notice> findByKeyword(@Param("keyword") String keyword);
    Work_Notice findTopByOrderByPubDateDesc();


}
