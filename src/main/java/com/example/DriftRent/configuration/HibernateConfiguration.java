package com.example.DriftRent.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Configuration class for setting up Hibernate SessionFactory.
 */
public class HibernateConfiguration {
    /**
     * Path to the Hibernate configuration file.
     */
    private static final String HIBERNATE_CONFIGURATION_FILE = "hibernate.cfg.xml";

    /**
     * Singleton instance of SessionFactory.
     */
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    /**
     * Builds the SessionFactory from the Hibernate configuration file.
     *
     * @return the built SessionFactory
     * @throws ExceptionInInitializerError if the SessionFactory creation fails
     */
    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure(HIBERNATE_CONFIGURATION_FILE);
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed because" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Gets the singleton instance of SessionFactory.
     *
     * @return the SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    /**
     * Shuts down the SessionFactory.
     */
    public static void shutdownSession() {
        getSessionFactory().close();
    }
}