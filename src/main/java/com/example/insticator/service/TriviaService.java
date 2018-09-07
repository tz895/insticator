package com.example.insticator.service;

import com.example.insticator.model.Trivia;

import java.util.List;

public interface TriviaService {
    List<Trivia> getAllTrivia();
    Trivia getById(int id);
    Trivia getRandom(int uid);
    void add(Trivia trivia);
    void update(Trivia trivia);
    void delete(int id);
    void build(int tid,int uid,int answer);
}
