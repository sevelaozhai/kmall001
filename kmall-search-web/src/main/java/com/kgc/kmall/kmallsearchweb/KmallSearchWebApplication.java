package com.kgc.kmall.kmallsearchweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.kgc.kmall"})
@SpringBootApplication
public class KmallSearchWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(KmallSearchWebApplication.class, args);
	}

}
