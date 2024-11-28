package com.example.DriftRent.repository.implementation;

import com.example.DriftRent.configuration.HibernateConfiguration;
import com.example.DriftRent.model.Car;
import com.example.DriftRent.repository.CarRepository;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CarRepositoryImpl implements CarRepository {

    @Override
    public Car save(Car entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Integer idOnCarSaved = (Integer) session.save(entity);
        transaction.commit();
        session.close();
        return findById(idOnCarSaved);
    }

    @Override
    public Car update(Car entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Integer newId = entity.getId();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
        return findById(newId);
    }

    @Override
    public Car findById(Integer id) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Car WHERE id = :id");
        query.setParameter("id", id);
        Car car;
        try {
            car = (Car) query.getSingleResult();
        } catch (QueryException e) {
            car = null;
        }
        transaction.commit();
        session.close();
        return car;
    }

    @Override
    public boolean delete(Car entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);

        transaction.commit();
        session.close();

        return true;
    }
}