package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.MyCourse;
import com.example.MJ_App_BE.data.entity.Semester;
import com.example.MJ_App_BE.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyCourseRepository extends JpaRepository<MyCourse, Long> {

//    @Query("SELECT u FROM MyCourse u WHERE u.myCourseUserId = :myCourseUserId")
//    MyCourse findByCourseUserId(@Param("myCourseUserId") Long myCourseUserId);

    List<MyCourse> findByUser(User user);

    List<MyCourse> findByUserAndYearAndSemester(User user, int year, Semester semester);

}
