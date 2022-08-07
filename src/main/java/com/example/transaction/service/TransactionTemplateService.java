package com.example.transaction.service;

import com.example.transaction.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class TransactionTemplateService {
    private final TransactionTemplate transactionTemplate;
    private final EntityManager entityManager;

    public int save() {
        try {
            int id = transactionTemplate.execute(status -> {
                var customer = new Customer( "Transaction template");
                entityManager.persist(customer);
                status.setRollbackOnly();
                return customer.getId();
            });
            return id;
        } catch (Exception ex) {
            return 0;
        }
    }
}
