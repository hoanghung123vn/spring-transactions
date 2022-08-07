package com.example.transaction.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionalSpringService {
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void save() {
        jdbcTemplate.execute("insert into customers(name) values ('Spring Plain')");
        throw new RuntimeException();
    }
}
