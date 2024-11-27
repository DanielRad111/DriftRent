package com.example.DriftRent.repository.implementation;

import com.example.DriftRent.configuration.HibernateConfiguration;
import com.example.DriftRent.model.User;
import com.example.DriftRent.repository.UserRepository;
import jakarta.persistence.TypedQuery;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User save(User entity){
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer idOnPersonSaved = (Integer) session.save(entity);
        transaction.commit();
        session.close();

        return findById(idOnPersonSaved);
    }

    @Override
    public User update(User entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = entity.getId();
        session.saveOrUpdate(entity);

        transaction.commit();
        session.close();

        return findById(id);
    }

    @Override
    public User findById(Integer id) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from User where id =: id");
        query.setParameter("id", id);

        User user;
        try {
            user = (User) query.getSingleResult();
        } catch (QueryException e) {
            user = null;
        }

        transaction.commit();
        session.close();

        return user;
    }

    @Override
    public boolean delete(User entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        Integer id = entity.getId();
//        if(email==null)
//            return false;
        session.delete(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public User findUserByEmail(String email) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        TypedQuery<User> query = session.getNamedQuery("findUserByEmail");
        query.setParameter("email", email);

        List<User> users = query.getResultList();
        User user = users.isEmpty() ? null : users.get(0);

        transaction.commit();
        session.close();

        return user;
    }

    @Override
    public User findUserByRating(Double rating) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        TypedQuery<User> query = session.getNamedQuery("findUserByRating");
        query.setParameter("rating", rating);

        User user;
        try{
            user = query.getSingleResult();
        }catch(QueryException e){
            user = null;
        }

        transaction.commit();
        session.close();

        return user;
    }
}