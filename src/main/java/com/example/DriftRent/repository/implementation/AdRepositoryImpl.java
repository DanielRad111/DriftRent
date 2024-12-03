package com.example.DriftRent.repository.implementation;

import com.example.DriftRent.configuration.HibernateConfiguration;
import com.example.DriftRent.model.Ad;
import com.example.DriftRent.model.Car;
import com.example.DriftRent.repository.AdRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AdRepositoryImpl implements AdRepository {

    @Override
    public Ad findAdByCar(Car car) {
        return null;
    }

    @Override
    public Ad findAdByTitle(String title) {
        return null;
    }

    @Override
    public Ad save(Ad entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer idOnAdSaved = (Integer) session.save(entity);
        transaction.commit();
        session.close();

        return findById(idOnAdSaved);
    }

    @Override
    public Ad update(Ad entity) {
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
    public Ad findById(Integer id) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Ad ad = session.get(Ad.class, id);

        transaction.commit();
        session.close();

        return ad;
    }

    @Override
    public boolean delete(Ad entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(entity);

        transaction.commit();
        session.close();

        return true;
    }
}
