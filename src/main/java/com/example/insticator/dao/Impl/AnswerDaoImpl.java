package com.example.insticator.dao.Impl;

import com.example.insticator.dao.AnswerDao;
import com.example.insticator.model.TAnswer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class AnswerDaoImpl implements AnswerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void TriviaBuild(TAnswer tAnswer) {
        entityManager.persist(tAnswer);
    }
}
