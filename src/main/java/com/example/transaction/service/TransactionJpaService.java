package com.example.transaction.service;


import com.example.transaction.entity.Customer;
import com.example.transaction.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionJpaService {
    private final CustomerRepository customerRepository;

    @Transactional
    public int save() {
        // start
        var customer = new Customer("Hibernate JPA");
        customerRepository.save(customer);
        throw new RuntimeException();
//        return customer.getId();
        // commit or rollback
    }
}
