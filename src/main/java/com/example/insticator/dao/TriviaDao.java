package com.example.insticator.dao;

import com.example.insticator.model.Trivia;

import java.util.List;

public interface TriviaDao {
    List<Trivia> getAllTrivia();
    Trivia getById(int id);
    Trivia getRandom(int uid);
    void add(Trivia trivia);
    void update(Trivia trivia);
    void delete(int id);
}
