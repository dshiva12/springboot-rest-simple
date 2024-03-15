package com.shiva.restsimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootRestSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestSimpleApplication.class, args);

	}

}
