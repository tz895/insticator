package com.example.insticator.service;

import com.example.insticator.model.Poll;

import java.util.List;

public interface PollService {
    List<Poll> getAllPoll();
    Poll getById(int id);
    Poll getRandom(int uid);
    void add(Poll poll);
    void update(Poll poll);
    void delete(int id);
    void build(int pid,int uid,String answer);
}
