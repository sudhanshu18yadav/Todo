package com.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class JournalApplication {

	// @Bean
	// InitializingBean saveData(JournalRepository repo) {
	// 	return ()->{
	// 		repo.save(new Journal("get to know spring boots", "todfay i will learn spring boopts", "01/01/2016"));
	// 		repo.save(new Journal("spring boots reading reading", "reading spree", "01/01/2016"));
	// 		repo.save(new Journal("spring boots cloud", "the cloud", "01/01/2016"));
	// 		repo.save(new Journal("spring boots backend dev", "the final backend", "01/01/2016"));
	// 	};
	// }

	public static void main(String[] args) {
		SpringApplication.run(JournalApplication.class, args);
	}

}
