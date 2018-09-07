package com.example.insticator.dao.Impl;

import com.example.insticator.dao.TriviaDao;
import com.example.insticator.model.Trivia;
import com.example.insticator.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class TriviaDaoImpl implements TriviaDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Trivia> getAllTrivia() {
        String hql = "FROM Trivia as t ORDER BY t.tId";
        return (List<Trivia>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Trivia getById(int id) {
        return entityManager.find(Trivia.class,id);
    }

    @Override
    public void add(Trivia trivia) {
        entityManager.persist(trivia);
    }

    @Override
    public void update(Trivia trivia) {
        Trivia t = getById(trivia.gettId());
        t.setContent(trivia.getContent());
        t.setCorrect(trivia.getCorrect());
        t.setAnswersA(trivia.getAnswersA());
        t.setAnswersB(trivia.getAnswersB());
        t.setAnswersC(trivia.getAnswersC());
        t.setAnswersD(trivia.getAnswersD());
        entityManager.flush();
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }

    @Override
    public Trivia getRandom(int uid) {
//        String hql = "FROM Trivia AS t WHERE t.tId  not in (SELECT tId FROM answered_trivial)";
//        String hql = "FROM Trivia as t ORDER BY t.tId";

//        String hql = "FROM Trivia as t WHERE t.tId NOT IN (SELECT s.tId FROM Trivia s JOIN s.users as u WHERE u.uId = :id)";

        String hql = "FROM Trivia as t WHERE t.tId NOT IN (SELECT s.tAnswerId.trivia.tId FROM TAnswer as s WHERE s.tAnswerId.user.uId = :id)";

        Query query =  entityManager.createQuery(hql);

        query.setParameter("id",uid);

        List<Trivia> lists = query.getResultList();

        if(lists.size() == 0) {
            return null;
        }
        return lists.get((int)(Math.random() * lists.size()));
    }

}
