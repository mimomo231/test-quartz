package com.example.testquartz.service.impl;

import com.example.testquartz.entity.UserInfo;
import com.example.testquartz.repository.UserRepository;
import com.example.testquartz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    @Override
    public UserInfo addUser(UserInfo userInfo) {
        System.out.println(userInfo.toString()  );
        return repository.save(userInfo);
    }

    @Override
    public UserInfo updateUser(UserInfo userInfo) {
        return repository.save(userInfo);
    }

    @Override
    public List<UserInfo> getAllUser() {
        return repository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserInfo getUserById(Long id) {
        return repository.findById(id).get();
    }
}
