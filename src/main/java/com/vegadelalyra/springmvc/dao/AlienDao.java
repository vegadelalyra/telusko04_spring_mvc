package com.vegadelalyra.springmvc.dao;

import com.vegadelalyra.springmvc.model.Alien;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlienDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Alien> getAliens() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Alien", Alien.class).list();
    }

    @Transactional
    public void addAlien(Alien a) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(a);
    }

    @Transactional
    public Alien getAlien(int aid) {

        Session session = sessionFactory.getCurrentSession();

        return session.get(Alien.class, aid);
    }
}
