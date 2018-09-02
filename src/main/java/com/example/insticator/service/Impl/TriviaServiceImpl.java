package com.example.insticator.service.Impl;

import com.example.insticator.dao.TriviaDao;
import com.example.insticator.model.Trivia;
import com.example.insticator.service.TriviaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriviaServiceImpl implements TriviaService {

    @Autowired
    private TriviaDao triviaDao;

    @Override
    public List<Trivia> getAllTrivia() {
        return triviaDao.getAllTrivia();
    }

    @Override
    public Trivia getById(int id) {
        return triviaDao.getById(id);
    }

    @Override
    public void add(Trivia trivia) {

        triviaDao.add(trivia);
    }

    @Override
    public void update(Trivia trivia) {

        triviaDao.update(trivia);
    }

    @Override
    public void delete(int id) {

        triviaDao.delete(id);
    }
}
