package com.example.insticator.dao.Impl;

import com.example.insticator.dao.PollDao;
import com.example.insticator.model.Poll;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class PollDaoImpl implements PollDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Poll> getAllPoll() {
        String hql = "FROM Poll as p ORDER BY p.pId";
        return (List<Poll>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Poll getById(int id) {
        return entityManager.find(Poll.class,id);
    }

    @Override
    public Poll getRandom(int uid) {
        String hql = "FROM Poll as p WHERE p.pId NOT IN (SELECT s.pAnswerId.poll.pId FROM PAnswer as s WHERE s.pAnswerId.user.uId = :id)";

        Query query =  entityManager.createQuery(hql);

        query.setParameter("id",uid);

        List<Poll> lists = query.getResultList();

        if(lists.size() == 0) {
            return null;
        }
        return lists.get((int)(Math.random() * lists.size()));
    }

    @Override
    public void add(Poll poll) {
        entityManager.persist(poll);
    }

    @Override
    public void update(Poll poll) {
        Poll p = getById(poll.getpId());
        p.setAnswersA(poll.getAnswersA());
        p.setAnswersB(poll.getAnswersB());
        p.setAnswersC(poll.getAnswersC());
        p.setAnswersD(poll.getAnswersD());
        p.setContent(poll.getContent());
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }
}
