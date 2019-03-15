package com.boraji.tutorial.spring03.service;

import java.util.List;

import com.boraji.tutorial.spring01.entity.User;

public interface UserService {
    void add(User user);
    List<User> listUsers();
}
