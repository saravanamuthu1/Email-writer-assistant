package com.email.writer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "emailGernator")
public class WriterEmailSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(WriterEmailSbApplication.class, args);
	}

}
