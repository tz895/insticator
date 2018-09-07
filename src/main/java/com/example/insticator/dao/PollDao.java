package com.example.insticator.dao;


import com.example.insticator.model.Poll;
import com.example.insticator.model.Trivia;

import java.util.List;

public interface PollDao {
    List<Poll> getAllPoll();
    Poll getById(int id);
    Poll getRandom(int uid);
    void add(Poll poll);
    void update(Poll poll);
    void delete(int id);
}
