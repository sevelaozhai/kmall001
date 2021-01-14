package com.kgc.kmall.kmallpassportweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.kgc.kmall"})
@SpringBootApplication
public class KmallPassportWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(KmallPassportWebApplication.class, args);
	}

}
