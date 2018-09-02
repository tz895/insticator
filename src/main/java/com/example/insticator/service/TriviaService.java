package com.example.insticator.service;

import com.example.insticator.model.Trivia;

import java.util.List;

public interface TriviaService {
    List<Trivia> getAllTrivia();
    Trivia getById(int id);
    void add(Trivia trivia);
    void update(Trivia trivia);
    void delete(int id);
}
