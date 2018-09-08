package com.example.insticator.service.Impl;

import com.example.insticator.dao.AnswerDao;
import com.example.insticator.dao.MatricDao;
import com.example.insticator.dao.UserDao;
import com.example.insticator.model.MAnswer;
import com.example.insticator.model.Matric;
import com.example.insticator.model.wrappedId.MAnswerId;
import com.example.insticator.service.MatricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatricServiceImpl implements MatricService {

    private MatricDao matricDao;
    private UserDao userDao;
    private AnswerDao answerDao;

    public MatricServiceImpl(MatricDao matricDao, UserDao userDao, AnswerDao answerDao) {
        this.matricDao = matricDao;
        this.userDao = userDao;
        this.answerDao = answerDao;
    }

    @Override
    public List<Matric> getAllMatric() {
        return matricDao.getAllMatric();
    }

    @Override
    public Matric getById(int id) {
        return matricDao.getById(id);
    }

    @Override
    public Matric getRandom(int uid) {
        return matricDao.getRandom(uid);
    }

    @Override
    public void add(Matric matric) {

        matricDao.add(matric);
    }

    @Override
    public void update(Matric matric) {

        matricDao.update(matric);
    }

    @Override
    public void delete(int id) {

        matricDao.delete(id);
    }

    @Override
    public void build(int mid, int uid, String answer) {
        MAnswerId mAnswerId = new MAnswerId(matricDao.getById(mid),userDao.getById(uid));
        MAnswer mAnswer = new MAnswer(mAnswerId,answer);

        answerDao.MatricBuild(mAnswer);
    }
}
