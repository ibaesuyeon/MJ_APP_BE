package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.Law_Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Law_NoticeRepository extends JpaRepository<Law_Notice, String> {

    @Query("SELECT n FROM Law_Notice n")
    List<Law_Notice> findAll();
    @Query("SELECT n FROM Law_Notice n WHERE n.title LIKE %:keyword%")
    List<Law_Notice> findByKeyword(@Param("keyword") String keyword);
    Law_Notice findTopByOrderByPubDateDesc();


}
