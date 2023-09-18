package com.example.testquartz.controller;

import com.example.testquartz.entity.UserInfo;
import com.example.testquartz.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "/api/test")
public class UserController {
    private final UserService userService;
    @Cacheable(value = "users", key = "#userId", unless = "#result.followers < 12000")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserInfo getUser(@PathVariable String userId) {
        log.info("Getting user with ID {}.", userId);
        return userService.getUserById(Long.valueOf(userId));
    }

    @CachePut(value = "users", key = "#user.id")
    @PutMapping("/update")
    public UserInfo updatePersonByID(@RequestBody UserInfo userInfo) {
        userService.updateUser(userInfo);
        return userInfo;
    }

    @CacheEvict(value = "users", allEntries=true)
    @DeleteMapping("/{id}")
    public void deleteUserByID(@PathVariable Long id) {
        log.info("deleting person with id {}", id);
        userService.deleteUser(id);
    }
    @PostMapping(produces = "application/json")
    public UserInfo addUser(@RequestBody UserInfo userInfo){
        return userService.addUser(userInfo);
    }
}
