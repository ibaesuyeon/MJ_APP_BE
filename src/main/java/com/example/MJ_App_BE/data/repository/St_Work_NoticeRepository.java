package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.St_Work_Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface St_Work_NoticeRepository extends JpaRepository<St_Work_Notice, String> {

    @Query("SELECT n FROM St_Work_Notice n")
    List<St_Work_Notice> findAll();
    @Query("SELECT n FROM St_Work_Notice n WHERE n.title LIKE %:keyword%")
    List<St_Work_Notice> findByKeyword(@Param("keyword") String keyword);
    St_Work_Notice findTopByOrderByPubDateDesc();


}
