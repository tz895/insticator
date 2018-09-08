package com.example.insticator.dao;

import com.example.insticator.model.Matric;

import java.util.List;

public interface MatricDao {
    List<Matric> getAllMatric();
    Matric getById(int id);
    Matric getRandom(int mid);
    void add(Matric matric);
    void update(Matric matric);
    void delete(int id);
}
