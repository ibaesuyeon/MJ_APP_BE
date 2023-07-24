package com.example.MJ_App_BE.data.repository;

import com.example.MJ_App_BE.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(Long userId);

    @Query("SELECT u FROM User u WHERE u.deviceId = :deviceId")
    User findByDeviceId(@Param("deviceId") String deviceId);
//    User findByDeviceId(String deviceId);

}
