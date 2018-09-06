package com.example.insticator.service;

import com.example.insticator.model.User;

public interface UserService {
    void add(User user);
    User getById(int id);
}
