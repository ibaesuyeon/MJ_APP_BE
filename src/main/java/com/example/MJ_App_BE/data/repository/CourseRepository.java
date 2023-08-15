package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.Course;
import com.example.MJ_App_BE.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {


}
