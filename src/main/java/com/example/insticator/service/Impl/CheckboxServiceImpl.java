package com.example.insticator.service.Impl;

import com.example.insticator.dao.AnswerDao;
import com.example.insticator.dao.CheckboxDao;
import com.example.insticator.dao.UserDao;
import com.example.insticator.model.CAnswer;
import com.example.insticator.model.Checkbox;
import com.example.insticator.model.wrappedId.CAnswerId;
import com.example.insticator.service.CheckboxService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckboxServiceImpl implements CheckboxService {

    private CheckboxDao checkboxDao;
    private UserDao userDao;
    private AnswerDao answerDao;

    public CheckboxServiceImpl(CheckboxDao checkboxDao, UserDao userDao, AnswerDao answerDao) {
        this.checkboxDao = checkboxDao;
        this.userDao = userDao;
        this.answerDao = answerDao;
    }

    @Override
    public List<Checkbox> getAllCheckbox() {
        return checkboxDao.getAllCheckbox();
    }

    @Override
    public Checkbox getById(int id) {
        return checkboxDao.getById(id);
    }

    @Override
    public Checkbox getRandom(int uid) {
        return checkboxDao.getRandom(uid);
    }

    @Override
    public void add(Checkbox checkbox) {
        checkboxDao.add(checkbox);
    }

    @Override
    public void update(Checkbox checkbox) {
        checkboxDao.update(checkbox);
    }

    @Override
    public void delete(int id) {
        checkboxDao.delete(id);
    }

    @Override
    public void build(int cid, int uid, String answer) {
        CAnswerId cAnswerId = new CAnswerId(checkboxDao.getById(cid),userDao.getById(uid));
        CAnswer cAnswer = new CAnswer(cAnswerId,answer);
        answerDao.CheckboxBuild(cAnswer);
    }
}
