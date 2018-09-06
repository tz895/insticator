package com.example.insticator.service.Impl;

import com.example.insticator.dao.UserDao;
import com.example.insticator.model.User;
import com.example.insticator.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }
}
