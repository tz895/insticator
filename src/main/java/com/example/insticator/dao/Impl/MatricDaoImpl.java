package com.example.insticator.dao.Impl;

import com.example.insticator.dao.MatricDao;
import com.example.insticator.model.Matric;
import com.example.insticator.model.Poll;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class MatricDaoImpl implements MatricDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Matric> getAllMatric() {
        String hql = "FROM Matric as m ORDER BY m.mId";
        return (List<Matric>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Matric getById(int id) {
        Matric matric = entityManager.find(Matric.class,id);
        Hibernate.initialize(matric.getColOptions());
        Hibernate.initialize(matric.getRowOptions());
        return matric;
    }

    @Override
    public Matric getRandom(int uid) {
        String hql = "FROM Matric as m WHERE m.mId NOT IN (SELECT s.mAnswerId.matric.mId FROM MAnswer as s WHERE s.mAnswerId.user.uId = :id)";

        Query query =  entityManager.createQuery(hql);

        query.setParameter("id",uid);

        List<Matric> lists = query.getResultList();

        if(lists.size() == 0) {
            return null;
        }

        Matric matric = lists.get((int)(Math.random() * lists.size()));

        Hibernate.initialize(matric.getColOptions());
        Hibernate.initialize(matric.getRowOptions());

        return matric;
    }

    @Override
    public void add(Matric matric) {
        entityManager.persist(matric);
    }

    @Override
    public void update(Matric matric) {
        Matric m = getById(matric.getmId());
        m.setRowOptions(matric.getRowOptions());
        m.setColOptions(matric.getColOptions());
        m.setContent(matric.getContent());
        m.setTitle(matric.getTitle());
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }
}
