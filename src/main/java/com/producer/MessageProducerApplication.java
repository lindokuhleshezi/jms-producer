package com.producer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;

import com.producer.model.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@Order(1)
public class MessageProducerApplication implements CommandLineRunner {


	Message msg = new Message();

	public static void main(String[] args) {
		SpringApplication.run(MessageProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("main class running");
	}

}
