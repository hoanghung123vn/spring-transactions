package com.example.transaction.service;

import com.example.transaction.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HibernateService {
    private final SessionFactory sessionFactory;

    public void savePlain() {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        var customer = new Customer("Plain Hibernate");
        session.save(customer);
//        session.getTransaction().rollback();
        session.getTransaction().commit();
        session.close();
    }

    @Transactional
    public void saveSpring () {
        var session = sessionFactory.openSession();
        var customer = new Customer("Hibernate Spring Transaction");
        session.save(customer);
//        throw new RuntimeException();
    }
}
