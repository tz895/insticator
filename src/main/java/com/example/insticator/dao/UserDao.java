package com.example.insticator.dao;

import com.example.insticator.model.User;

public interface UserDao {
    void addUser(User user);
    User getById(int id);
}
