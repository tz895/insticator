package com.example.insticator.dao;

import com.example.insticator.model.Checkbox;

import java.util.List;

public interface CheckboxDao {
    List<Checkbox> getAllCheckbox();
    Checkbox getById(int id);
    Checkbox getRandom(int uid);
    void add(Checkbox checkbox);
    void update(Checkbox checkbox);
    void delete(int id);
}
