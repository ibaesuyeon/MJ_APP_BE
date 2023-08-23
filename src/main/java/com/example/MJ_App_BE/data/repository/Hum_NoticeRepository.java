package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.Hum_Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Hum_NoticeRepository extends JpaRepository<Hum_Notice, String> {

    @Query("SELECT n FROM Hum_Notice n")
    List<Hum_Notice> findAll();
    @Query("SELECT n FROM Hum_Notice n WHERE n.title LIKE %:keyword%")
    List<Hum_Notice> findByKeyword(@Param("keyword") String keyword);
    Hum_Notice findTopByOrderByPubDateDesc();


}
