package com.shunya.studios.middleware;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@Testcontainers
@SpringBootTest
class ShunyaStudiosMiddlewareServiceApplicationTests {

	@Container
  	static PostgreSQLContainer<?> pg = new PostgreSQLContainer<>("postgres:16");

	@DynamicPropertySource
	static void pgProps(DynamicPropertyRegistry r) {
		r.add("spring.datasource.url", pg::getJdbcUrl);
		r.add("spring.datasource.username", pg::getUsername);
		r.add("spring.datasource.password", pg::getPassword);
	}


	@Test
	void contextLoads() {
	}

}
