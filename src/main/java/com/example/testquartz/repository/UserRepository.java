package com.example.testquartz.repository;

import com.example.testquartz.entity.UserInfo;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface UserRepository extends JpaRepository<UserInfo, Long> {
}
