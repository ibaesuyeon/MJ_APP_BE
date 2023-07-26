package com.example.MJ_App_BE.data.dao;

import com.example.MJ_App_BE.data.entity.Credits;
import com.example.MJ_App_BE.data.entity.User;
import com.example.MJ_App_BE.exception.UserException;

public interface CreditsDao {
    Credits getCredits(Long creditsMajorId);

}
