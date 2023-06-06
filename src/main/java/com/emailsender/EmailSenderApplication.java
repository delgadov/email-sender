package com.emailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.emailsender")
public class EmailSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailSenderApplication.class, args);
	}

}
