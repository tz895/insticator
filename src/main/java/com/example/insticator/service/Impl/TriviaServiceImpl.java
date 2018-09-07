package com.example.insticator.service.Impl;

import com.example.insticator.dao.AnswerDao;
import com.example.insticator.dao.TriviaDao;
import com.example.insticator.dao.UserDao;
import com.example.insticator.model.TAnswer;
import com.example.insticator.model.TAnswerId;
import com.example.insticator.model.Trivia;
import com.example.insticator.model.User;
import com.example.insticator.service.TriviaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriviaServiceImpl implements TriviaService {

    private TriviaDao triviaDao;
    private UserDao userDao;
    private AnswerDao answerDao;

    public TriviaServiceImpl(TriviaDao triviaDao, UserDao userDao, AnswerDao answerDao) {
        this.triviaDao = triviaDao;
        this.userDao = userDao;
        this.answerDao = answerDao;
    }

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

    @Override
    public Trivia getRandom(int uid) {
        return triviaDao.getRandom(uid);
    }

    @Override
    public void build(int tid, int uid,int answer) {

        TAnswerId tAnswerId = new TAnswerId(triviaDao.getById(tid),userDao.getById(uid));
        TAnswer tAnswer = new TAnswer(tAnswerId,answer);
        answerDao.TriviaBuild(tAnswer);
    }
}
