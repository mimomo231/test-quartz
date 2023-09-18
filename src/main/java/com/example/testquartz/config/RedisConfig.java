package com.example.testquartz.config;

import com.example.testquartz.entity.UserInfo;
import com.example.testquartz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
@Slf4j
@RequiredArgsConstructor
public class RedisConfig {
    private final UserRepository userRepository;
//    @Bean
    public void doAdd() {
        //Populating embedded database here
        log.info("Saving users. Current user count is {}.", userRepository.count());
        UserInfo t1 = new UserInfo();
        t1.setFollowers(1000);
        t1.setName("test1");
        UserInfo t2 = new UserInfo();
        t2.setFollowers(1000);
        t2.setName("test2");
        UserInfo t3 = new UserInfo();
        t3.setFollowers(1000);
        t3.setName("test3");

        userRepository.save(t1);
        userRepository.save(t2);
        userRepository.save(t3);
        log.info("Done saving users. Data: {}.", userRepository.findAll());
    }
}
