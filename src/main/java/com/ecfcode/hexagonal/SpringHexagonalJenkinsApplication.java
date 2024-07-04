package com.ecfcode.hexagonal;

import com.ecfcode.hexagonal.infrastructure.abstracts.RoleRepository;
import com.ecfcode.hexagonal.infrastructure.entities.concretes.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringHexagonalJenkinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHexagonalJenkinsApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository) {
		return args -> {
			if(roleRepository.findByName("USER").isEmpty()){
				roleRepository.save(
						Role.builder().name("USER").build()
				);
			}
		};
	}
}
