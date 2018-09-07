package com.example.insticator.dao.Impl;

import com.example.insticator.dao.CheckboxDao;
import com.example.insticator.model.Checkbox;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CheckboxDaoImpl implements CheckboxDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Checkbox> getAllCheckbox() {
        String hql = "FROM Checkbox as c ORDER BY c.cId";
        return (List<Checkbox>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Checkbox getById(int id) {
        return entityManager.find(Checkbox.class,id);
    }

    @Override
    public Checkbox getRandom(int uid) {
        String hql = "FROM Checkbox as c WHERE c.cId NOT IN (SELECT s.cAnswerId.checkbox.cId FROM CAnswer as s WHERE s.cAnswerId.user.uId = :id)";

        Query query =  entityManager.createQuery(hql);

        query.setParameter("id",uid);

        List<Checkbox> lists = query.getResultList();

        if(lists.size() == 0) {
            return null;
        }
        return lists.get((int)(Math.random() * lists.size()));
    }

    @Override
    public void add(Checkbox checkbox) {
        entityManager.persist(checkbox);
    }

    @Override
    public void update(Checkbox checkbox) {
        Checkbox c = getById(checkbox.getcId());
        c.setContent(checkbox.getContent());
        c.setOption1(checkbox.getOption1());
        c.setOption2(checkbox.getOption2());
        c.setOption3(checkbox.getOption3());
        c.setOption4(checkbox.getOption4());
        c.setOption5(checkbox.getOption5());
        c.setOption6(checkbox.getOption6());
        c.setOption7(checkbox.getOption7());
        c.setOption8(checkbox.getOption8());
        c.setOption9(checkbox.getOption9());
        c.setOption10(checkbox.getOption10());

    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }
}
