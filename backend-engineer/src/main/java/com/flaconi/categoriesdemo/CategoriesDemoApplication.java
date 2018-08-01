package com.flaconi.categoriesdemo;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@SpringBootApplication
@EnableJpaAuditing
public class CategoriesDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoriesDemoApplication.class, args);
	}

	@Bean
	public Filter filter() {
		return new ShallowEtagHeaderFilter();
	}
}
