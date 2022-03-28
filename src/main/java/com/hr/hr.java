package com.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication()
@EntityScan("com.hr.entity")
@EnableJpaRepositories("com.hr.repository")

public class hr {

	public static void main(String[] args) {
		SpringApplication.run(hr.class, args);

	}
	

}