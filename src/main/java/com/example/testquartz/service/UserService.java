package com.example.testquartz.service;

import com.example.testquartz.entity.UserInfo;

import java.util.List;

public interface UserService {
    UserInfo addUser(UserInfo userInfo);
    UserInfo updateUser(UserInfo userInfo);
    List<UserInfo> getAllUser();
    void deleteUser(Long id);
    UserInfo getUserById(Long id);
}
