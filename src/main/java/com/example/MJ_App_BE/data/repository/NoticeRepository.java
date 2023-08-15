package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.Notice;
import com.example.MJ_App_BE.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, String> {

    @Query("SELECT n FROM Notice n WHERE n.category = :category")
    List<Notice> findByCategory(@Param("category") String category);
//    Notice findByCategory(String category);
    @Query("SELECT n FROM Notice n WHERE n.title LIKE %:keyword%")
    List<Notice> findAllByKeyword(@Param("keyword") String keyword);

    @Query("SELECT n FROM Notice n WHERE n.category = :category AND n.title LIKE %:keyword%")
    List<Notice> findByCategoryAndKeyword(@Param("category") String category, @Param("keyword") String keyword);
}
