package com.example.transaction.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class JDBCService {
    private final JdbcTemplate jdbcTemplate;

    public void save() {
            jdbcTemplate.execute("insert into customers(name) values ('JDBC Plain')",
                    (PreparedStatementCallback<Integer>) stmt -> {
                // step 1
                var connection = stmt.getConnection();
                //step 2
                connection.setAutoCommit(false);
                try {
                    stmt.execute();
//                    throw new SQLException();
                } catch (SQLException ex) {
                    connection.rollback();
                }
                connection.commit();
                connection.setAutoCommit(true);
                return 0;
            });
    }
}
