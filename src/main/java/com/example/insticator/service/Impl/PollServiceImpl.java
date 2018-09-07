package com.example.insticator.service.Impl;

import com.example.insticator.dao.AnswerDao;
import com.example.insticator.dao.PollDao;
import com.example.insticator.dao.UserDao;
import com.example.insticator.model.PAnswer;
import com.example.insticator.model.wrappedId.PAnswerId;
import com.example.insticator.model.Poll;
import com.example.insticator.service.PollService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollServiceImpl implements PollService {

    private PollDao pollDao;
    private UserDao userDao;
    private AnswerDao answerDao;

    public PollServiceImpl(PollDao pollDao, UserDao userDao, AnswerDao answerDao) {
        this.pollDao = pollDao;
        this.userDao = userDao;
        this.answerDao = answerDao;
    }

    @Override
    public List<Poll> getAllPoll() {
        return pollDao.getAllPoll();
    }

    @Override
    public Poll getById(int id) {
        return pollDao.getById(id);
    }

    @Override
    public Poll getRandom(int uid) {
        return pollDao.getRandom(uid);
    }

    @Override
    public void add(Poll poll) {
        pollDao.add(poll);
    }

    @Override
    public void update(Poll poll) {
        pollDao.update(poll);
    }

    @Override
    public void delete(int id) {
        pollDao.delete(id);
    }

    @Override
    public void build(int pid, int uid, String answer) {

        PAnswerId pAnswerId = new PAnswerId(pollDao.getById(pid),userDao.getById(uid));
        PAnswer pAnswer = new PAnswer(pAnswerId,answer);
        answerDao.PollBuild(pAnswer);
    }
}
