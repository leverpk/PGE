package com.example.demo;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {

	private final CategoryRepository categoryRepository;

	private static final Logger logger = LogManager.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		logger.info("We've just greeted the user!");
		logger.warn("We've just greeted the user!");
		logger.error("We've just greeted the user!");
	}

	@Override
	public void run(String... args) throws Exception {
		Category teams = categoryRepository.save(Category.builder()
			.name("Drużyny").build());
		Category table = categoryRepository.save(Category.builder()
			.name("Tabela").build());
	}
}
