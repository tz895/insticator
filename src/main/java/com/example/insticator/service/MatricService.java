package com.example.insticator.service;

import com.example.insticator.model.Matric;

import java.util.List;

public interface MatricService {
    List<Matric> getAllMatric();
    Matric getById(int id);
    Matric getRandom(int mid);
    void add(Matric matric);
    void update(Matric matric);
    void delete(int id);
    void build(int mid,int uid,String answer);
}
