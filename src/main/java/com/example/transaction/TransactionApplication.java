package com.example.transaction;

import com.example.transaction.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class TransactionApplication implements CommandLineRunner {
	private final JDBCService jdbcService;
	private final TransactionTemplateService transactionTemplateService;
	private final TransactionalSpringService transactionalSpringService;
	private final HibernateService hibernateService;
	private final TransactionJpaService transactionJpaService;

	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
//			jdbcService.save();
//			transactionTemplateService.save();
//			transactionalSpringService.save();
			hibernateService.savePlain();
			hibernateService.saveSpring();
			transactionJpaService.save();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
