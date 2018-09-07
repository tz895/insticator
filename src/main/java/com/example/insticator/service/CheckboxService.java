package com.example.insticator.service;

import com.example.insticator.model.Checkbox;

import java.util.List;

public interface CheckboxService {
    List<Checkbox> getAllCheckbox();
    Checkbox getById(int id);
    Checkbox getRandom(int uid);
    void add(Checkbox poll);
    void update(Checkbox poll);
    void delete(int id);
    void build(int cid,int uid,String answer);
}
