package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, String> {

    @Query("SELECT n FROM Notice n")
    List<Notice> findAll();
    @Query("SELECT n FROM Notice n WHERE n.title LIKE %:keyword%")
    List<Notice> findByKeyword(@Param("keyword") String keyword);
    Notice findTopByOrderByPubDateDesc();


}
